package base;

import java.time.LocalDate;

public class AudioBook extends Book {

    // 추가 필드 작성
    private String fileSize;
    private String language;
    private int playTime;

    // Book class 에서 오버라이딩
    public AudioBook(Long id, String name, String author, Long isbn, LocalDate publishedDate, String fileSize, String language, int playTime) {
        this.setId(id);           // set~ : Book 클래스에서 가져오는 것 (값을 초기화 함)
        this.setName(name);
        this.setAuthor(author);
        this.setIsbn(isbn);
        this.setPublishedDate(publishedDate);
        this.fileSize = fileSize;       // 값 초기화
        this.language = language;
        this.playTime = playTime;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getFileSize() {
        return fileSize;
    }
    public String getLanguage() {
        return language;
    }
    public int getPlayTime () {
        return playTime;
    }
}
