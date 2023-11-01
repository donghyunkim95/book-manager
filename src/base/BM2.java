package base;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class BM2 extends BookManager{
    private static ArrayList<Book> bookList = new ArrayList<>();  //add 로 안에 들어올값들을 추가함
    // 타입명 <Book> : book 이라는 객체만 담을수 있다.
    // 타입명 <Integer>라면 : 정수 객체만 담을 수 있다.
    private static Scanner sc = new Scanner(System.in);
    @Override
    void init() {  //bookList : Arraylist
        bookList.add(new Book(1L, "돈의 속성(300쇄 리커버에디션)", "김승호", Long.parseLong("9791188331796"),
                LocalDate.parse("2020-06-15")));
        bookList.add(new EBook(2L,"K 배터리 레볼루션", "박순혁", Long.parseLong("9791191521221"), LocalDate.parse("2023-02-20"),
                "300MB"));
        bookList.add(new AudioBook(3L, "위기의 역사", "오건영", Long.parseLong("9791169850360"), LocalDate.parse("2023-07-19"),
                "562MB", "한국어", 120));
    }
    @Override
    void interactWithUser() {
        while (true) {
            System.out.println("■■■■■■ 도서 관리 프로그램 ■■■■■■");
            System.out.println("(1) 도서 조회");
            System.out.println("(2) 도서 등록");
            System.out.println("(3) 도서 수정");
            System.out.println("(4) 도서 삭제");
            System.out.println("(q) 프로그램 종료");
            System.out.print("선택 >> ");
            String userInput = sc.nextLine();
            switch (userInput) {
                case "1":
                    // 조회
                    printAllBook();
                    break;
                case "2":
                    // 등록
                    addBook();
                    break;
                case "3":
                    // 수정
                    updateBook();
                    break;
                case "4":
                    // 삭제
                    removeBook();
                    break;
                case "q":
                    // 메소드를 종료
                    System.out.println("프로그램 종료!");
                    return;
                default:
                    System.out.println("보기에 나와있는 것을 입력하세요!!! :( ");
                    break;
            }

        }
    }
    @Override
    public void printAllBook() {
        System.out.println("■■■■■■■■ 도서 목록 조회 ■■■■■■■■");
        for (Book book : bookList) {
            System.out.print("[");
            System.out.print(book.getId());
            System.out.print(", ");
            System.out.print(book.getName());
            System.out.print(", ");
            System.out.print(book.getAuthor());
            System.out.print(", ");
            System.out.print(book.getIsbn());
            System.out.print(", ");
            System.out.print(book.getPublishedDate());
            if(book instanceof EBook) {
                System.out.print(", ");
                System.out.print(((EBook) book).getFileSize());
                System.out.print("]");
            } else if (book instanceof AudioBook) {
                System.out.print(", ");
                System.out.print(((AudioBook) book).getFileSize());
                System.out.print(", ");
                System.out.print(((AudioBook) book).getLanguage());
                System.out.print(", ");
                System.out.print(((AudioBook) book).getPlayTime());
                System.out.print("]");
            } else System.out.print("]");
            System.out.println();
        }
    }
    public void addBook() {
        System.out.println("■■■■■■■■■■■ 도서 등록 ■■■■■■■■■■■");
        System.out.println("어떤 책을 등록하시겠습니까?(숫자입력) 1. Book 2. EBook 3. AudioBook");
        System.out.print(">> ");
        String book = sc.nextLine();            // 문자열로 선언
        int form = Integer.parseInt(book);      // 1. 2. 3. 을 위해 정수형으로 변환
        if(form >= 4 || form <= 0) {            // && (2가지 조건 다 만족해야함) 말고 무조건 || 사용!
            // 1, 2, 3 만 통과되게 하는 if 문
            System.out.println("잘못된 숫자 입력하였습니다!!! :( ");
            return; // addBook 실행을 종료시킨다는 의미
        }
        System.out.print("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
        String id = sc.nextLine();          // String 으로 입력값을 일단 다 받아준다.
        if(Check(Long.parseLong(id)) == null) {    // Check : 세한님이 만드신 메서드 - 인자값으로 id 받는다 - id check
            // Check 메서드 호출 - id 하나 "만" 비교 하는 메서드임

            // 아래 Check 메서드에서 값이 달라서 return null 을 뱉어내면 .
            // 위의 if 문이 null == null 이 되어 -> true -> if 문 실행

            // 꼭 선언해주자!!!! 왜냐하면
            // 바깥에서 선언 해준 후 아래 if 문에서 활용하기때문에 String file, lang~ time을 ""; 로 초기화함
            // String file; 해도 되지만 -> 아무것도 안 찍히더라도 값이 출력되는게 더 낫다.
            String file = "";
            String language = "";
            String time = "";


            System.out.print("(2) 도서명을 입력해주세요. >> ");
            String name = sc.nextLine();
            System.out.print("(3) 저자명을 입력해주세요. >> ");
            String author = sc.nextLine();
            System.out.print("(4) isbn을 입력해주세요. >> ");
            String isbn = sc.nextLine();
            System.out.print("(5) 출간일을 입력해주세요.(YYYY-MM-DD형식) >> ");
            String publishDate = sc.nextLine();
            if(form >= 2) {
                System.out.print("(6) 파일 사이즈를 입력해주세요. >> ");
                file = sc.nextLine();
                if(form >= 3) {  // 컴퓨터가 경계를 넘어갈 만약의 경우를 대비하여 form >=3 으로 선언. form ==3 도 사용가능한 표현이다.
                    System.out.print("(7) 언어를 입력해주세요. >> ");
                    language = sc.nextLine();
                    System.out.print("(8) 오디오북 길이를 입력해주세요.(숫자) >> ");
                    time = sc.nextLine();
                }
            }
            switch (form) { // switch 조건문
                case 1:
                    Book book1 = new Book(Long.parseLong(id), // 생성자.
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate)); // 인스턴스를 bookList 에 넣어줌
                    bookList.add(book1);
                    System.out.println("--- 도서 [" + book1.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 2:
                    Book book2 = new EBook(Long.parseLong(id),  // 객체들을 생성한다.
                            name,                                // 이 객체들을 .add 이용해서 bookList에 넣어준다.
                            author,                              // book2 위의 객체들을 담는 이름이다.
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), file);
                    bookList.add(book2);
                    System.out.println("--- 도서 [" + book2.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                case 3:
                    Book book3 = new AudioBook(Long.parseLong(id),
                            name,
                            author,
                            Long.parseLong(isbn),
                            LocalDate.parse(publishDate), file, language, Integer.parseInt(time));
                    bookList.add(book3);
                    System.out.println("--- 도서 [" + book3.getName() + "] 등록이 완료되었습니다. ---");
                    break;
                default:        // 혹시 모르는 상황 : case에 안 적어준 값이 출력됐을 때를 대비하
                    break;
            }
        } else System.out.println("ID값이 이미 존재합니다. ");
    }
    @Override
    public void updateBook() {
        System.out.println("수정 메서드 실행");
        System.out.print("수정하고자 하는 도서번호를 입력하세요: ");

        // long id : 내가 입력한 id
        long id = Long.parseLong(sc.nextLine());

        Book check = Check(id);  // Book 이 참조타입
        //   입력받은 id 값이랑 같은 값을 가지는 Book객체의 이름 : check

        int i=0;  // i 값은 1,2,3번 이다.
        if (check != null) {
            String fileSize = "";
            String language = "";
            String time = "";
            System.out.println("[수정 정보를 입력해주세요]");
            System.out.print("제목: ");
            String name = sc.nextLine();
            System.out.print("저자: ");
            String author = sc.nextLine();
            System.out.print("isbn: ");
            String isbn = sc.nextLine();
            System.out.print("출판일(YYYY-MM-DD): ");
            String publishDate = sc.nextLine();
            i++; // i=0 에서 +1 되었다는 것.     i = i+1 이게 더 정확한 의미(i=0 이 선언 안되었을때)
            // i=1; 해도 상관은 없다.
            if (check instanceof EBook) {
                System.out.print("파일사이즈: ");
                fileSize = sc.nextLine();
                i=2;
            }else if (check instanceof AudioBook) {
                System.out.print("파일사이즈: ");
                fileSize = sc.nextLine();
                System.out.print("언어: ");
                language = sc.nextLine();
                System.out.print("재생시간(숫자): ");
                time = sc.nextLine();
                i=3;
            }
            switch (i) {   // book 객체의 필드를 바꿔주는 것 !
                case 1:
                    check.setName(name);
                    check.setAuthor(author);
                    check.setIsbn(Long.parseLong(isbn));
                    check.setPublishedDate(LocalDate.parse(publishDate));
                    break;
                case 2:
                    check.setName(name);
                    check.setAuthor(author);
                    check.setIsbn(Long.parseLong(isbn));
                    check.setPublishedDate(LocalDate.parse(publishDate));
                    ((EBook)check).setFileSize(fileSize);     // 177번 EBook 강제변환 : 위에서 Book check 으로 선언해줬기 때문
                    break;
                case 3:
                    check.setName(name);
                    check.setAuthor(author);
                    check.setIsbn(Long.parseLong(isbn));
                    check.setPublishedDate(LocalDate.parse(publishDate));
                    ((AudioBook) check).setFileSize(fileSize);
                    ((AudioBook) check).setLanguage(language);
                    ((AudioBook) check).setPlayTime(Integer.parseInt(time));
                    break;
                default:        // 혹시 모르는 상황 : case에 안 적어준 값이 출력됐을 때를 대비하기위해
                    // case에 없는 상황은 default: 에서 처리해준다.
                    break;

            }
            System.out.println("수정이 완료되었습니다.");
        }else System.out.println("해당 도서가 존재하지 않습니다!!! ");
    }
    public void removeBook() {
        System.out.println("■■■■■■■■■■■ 도서 삭제 ■■■■■■■■■■■");
        System.out.println("삭제하고자 하는 도서의 도서번호를 입력하세요.");
        System.out.print("선택 >> ");
        Book check = Check(Long.parseLong(sc.nextLine()));
        if(check != null) {
            bookList.remove(check);
            System.out.println("삭제가 완료되었습니다.");
        } else System.out.println("해당 도서가 존재하지 않습니다.");
    }
    public Book Check(long id) { // return 타입 형태 : [접근제한자 + return타입 + method 이름 Check 임의로 정할수있다.]
        for (Book b : bookList){   // 향상된 for 문 : bookList = arraylist 안에 있는 book 들을 하나하나 확인한다
            if(b.getId().equals(id)){   // 103번 String id 에서 가져온 id 임
                // b.getId() 는 bookList 안에있는 id  / equals(id) => 입력받은 id
                // b.getId() 는 1,2,3 번 (도서목록조회하면 나오는애들)
                return b;
            }
        } return null;   // for 문이 다 돌면 return null
    }

}

