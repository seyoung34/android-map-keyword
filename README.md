# android-map-keyword

###1단계###

1. main ui 만들기
   1. 검색어 입력 창 (editText)
   2. 검색어 삭제 x 표시
   3. 검색결과를 보여주는 뷰 (ListView or recyclerView)
   4. 아이템뷰 만들기

2. SQLite 설계
   1. SQLiteOpenHelper 클래스 생성
   2. SQLiteDatabase 클래스 생성
      1. insert함수 작성
      2. select함수 작성