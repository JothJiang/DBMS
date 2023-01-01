package test.dao;

import test.entity.TeachingBooks;

public interface TeachingBooksDao {
    void addTeachingBooks( TeachingBooks teachingBooks);
    void upTeachingBooks(TeachingBooks teachingBooks);
    void deleteTeachingBooks(int teachingBooks_id);
    int getTeachingBooksId();
    TeachingBooks getTeachingBooks(int TeachingBooks_id);
}
