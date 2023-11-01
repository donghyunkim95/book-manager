package base;

public class Execute {
    static BookManager bm = new BM2();

    public static void main(String[] args) {
        bm.init();
        bm.interactWithUser();
    }
}
//public class Execute {
//    // 사용자 입력을 받기 위한 스캐너 객체
//    static Scanner sc = new Scanner(System.in);
//    static BM bm = new BM();
//    public static void main(String[] args) {
//
//        while (true) {
//            System.out.println("■■■■■■■■ 도서 관리 프로그램 ■■■■■■■■");
//            System.out.println("(1) 도서 조회");
//            System.out.println("(2) 도서 등록");
//            System.out.println("(3) 도서 수정");
//            System.out.println("(4) 도서 삭제");
//            System.out.println("(q) 프로그램 종료");
//            System.out.print("선택 >> ");
//            String userInput = sc.nextLine();
//
//            switch (userInput) {
//                case "1":
//                    // 조회
//                    printAllBook();
//                    break;
//                case "2":
//                    // 등록
//                    addBook();
//                    break;
//                case "3":
//                    // 수정
//                    updateBook();
//                    break;
//                case "4":
//                    // 삭제
//                    deleteBook();
//                    break;
//                case "q":
//                    System.out.println("프로그램 종료!");
//                    return; // 메소드를 종료
//                default:
//                    System.out.println("보기에 나와있는 것을 입력하세요!!! :( ");
//                    break;
//            }
//
//        }
//    }
//
//    private static void deleteBook() {
//        System.out.println("■■■■■■■■■■■ 도서 삭제 ■■■■■■■■■■■");
//        System.out.println("삭제하고자 하는 도서의 도서번호를 입력하세요.");
//        System.out.print("선택 >> ");
//        bm.removeBook(Long.parseLong(sc.nextLine()));
//    }
//
//    private static void updateBook() {
//        System.out.println("수정 메서드 실행");
//        System.out.print("수정하고자 하는 도서번호를 입력하세요: ");
//        long id = Long.parseLong(sc.nextLine());
//        if(bm.checkBook(id)) {
//            System.out.println("[수정 정보를 입력해주세요]");
//            System.out.print("제목: ");
//            String name = sc.nextLine();
//            System.out.print("저자: ");
//            String author = sc.nextLine();
//            System.out.print("isbn: ");
//            String isbn = sc.nextLine();
//            System.out.print("출판일(YYYY-MM-DD): ");
//            String publishDate = sc.nextLine();
//            Book book = new Book(id,
//                    name,
//                    author,
//                    Long.parseLong(isbn),
//                    LocalDate.parse(publishDate));
//            bm.updateBook(book);
//        }
//    }
//
//    private static void addBook() {
//        System.out.println("■■■■■■■■■■■ 도서 등록 ■■■■■■■■■■■");
//        // 1. 콘솔화면을 통해 사용자로부터 도서정보를 입력을 받는다.
//            // id, 제목, 저자, isbn, 출판일 (5가지) (v)
//            // 위의 정보로 책 객체를 생성한다. (v)
//        // 2. 도서를 등록한다.
//            // 사서를 통해 도서 저장 요청
//
//        System.out.print("(1) 도서번호를 입력해주세요.(유일한 번호) >> ");
//        String id = sc.nextLine();
//        if(bm.idCheck(Long.parseLong(id))) {
//            System.out.print("(2) 도서명을 입력해주세요. >> ");
//            String name = sc.nextLine();
//            System.out.print("(3) 저자명을 입력해주세요. >> ");
//            String author = sc.nextLine();
//            System.out.print("(4) isbn을 입력해주세요. >> ");
//            String isbn = sc.nextLine();
//            System.out.print("(5) 출간일을 입력해주세요.(YYYY-MM-DD형식) >> ");
//            String publishDate = sc.nextLine();
//
//            // id, isbn는 String 타입이므로 Long으로 변환 후 매개값을 주어야한다.
//            // publishedDate는 String 타입인데 LocalDate 타입으로 변환해주어야 한다. ==> "구글링"
//            Book book = new Book(Long.parseLong(id),
//                    name,
//                    author,
//                    Long.parseLong(isbn),
//                    LocalDate.parse(publishDate));
//
//            bm.addBook(book);
//        } else System.out.println("ID값이 이미 존재합니다. ");
//    }
//
//    private static void printAllBook() {
//        System.out.println("■■■■■■■■ 도서 목록 조회 ■■■■■■■■");
//        bm.printAllBook();
//    }
//}
