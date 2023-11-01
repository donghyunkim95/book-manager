package base;

public abstract class BookManager {
    // 기존 코드에서 + init(), + interactWithUser() 추가!!
    abstract void init();
    abstract void interactWithUser();
//    abstract void addBook(Book book);
//    상속받은 건 무조건 오버라이드 해줘야하는데 현재는 필요 없음, 해당 코드는 book 인자 사용하는 것이고, 초반에 사용했었음

    public abstract void addBook();
    // 매개 변수가 없는거 :실제 사용
    abstract void printAllBook();
//    abstract void updateBook(Book book);
//    abstract void removeBook(long id);

    public abstract void updateBook();

    public abstract void removeBook();
}
