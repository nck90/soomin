package io.github.cuzurmyhabit;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.QuerySnapshot;

public class Student extends User {

    public Student(int room, int grade, int classRoom, String name) {
        super(room, grade, classRoom, name);
    }

    @Override
    public boolean authenticate(int room, int grade, int classRoom, String name) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<QuerySnapshot> query = db.collection("student_info")
                .whereEqualTo("room", room)
                .whereEqualTo("grade", grade)
                .whereEqualTo("class", classRoom)
                .whereEqualTo("name", name)
                .get();

        try {
            return !query.get().isEmpty();
        } catch (Exception e) {
            System.err.println("인증 과정 중 오류 발생: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}