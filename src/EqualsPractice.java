public class EqualsPractice {
    public static void searchKeyword(String searchType){
        if (searchType == "title") {
            System.out.println("제목으로 검색");
        }
        else {
            System.out.println("내용으로 검색");
        }

        if (searchType.equals("title")) {
            System.out.println("제목으로 검색");
        }
        else {
            System.out.println("내용으로 검색");
        }
    }

    public static void main(String[] args) {
        String title = new String("title");
        searchKeyword(title);
    }
}
