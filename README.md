# 콘솔 게시판
<br>

> 게시판 설명
> 
콘솔을 활용한 게시판
회원가입을 하여 게시글을 작성할 수 있다.<br> 
작성한 게시글은 5개씩 한페이지로 구성되어 보여지며, "a"를 눌러 이전 페이지, "d"를 눌러 다음 페이지로 넘어갈 수 있다.<br>
나만의 게시글을 자유롭게 작성할 수 있는 콘솔 게시판이다.<br><br>
> 게시판 기능
1. 회원가입
2. 회원탈퇴
3. 로그인
4. 로그아웃
5. 게시글 작성
6. 게시글 조회
7. 마이페이지
0. 종료

#### 회원가입
* 문자열 또는 숫자로 이루어진 id와 password를 입력하여 회원가입할 수 있다.
* ( 중복된 id는 사용할 수 없다. )

#### 회원탈퇴
* password를 입력하여 본인 확인을 한 후 본인 확인이 완료되면 탈퇴한다.

#### 로그인 
* 회원가입 시 기입했던 id와 password를 입력하여 올바른 회원정보가 확인되면 로그인한다.

#### 로그아웃
* 로그인 하고 있던 유저의 log를 지우고 로그아웃한다.

#### 게시글 작성
* 원하는 나만의 게시글을 작성할 수 있다.
* 제목과 내용을 적어서 나만의 게시글을 완성한다.
* 문장의 마지막에 .을 작성하면 게시글 작성을 종료할 수 있다.

#### 게시글 조회
* 현재 페이지 내에 있는 게시글 중 원하는 게시글의 번호를 입력하면 해당 게시글의 내용을 조회할 수 있다.

#### 마이페이지
1. 내 게시글 조회
   * 현재 로그인 하고 있는 유저가 작성한 모든 게시글을 보여준다.
   * 조회를 원하는 게시글 번호를 입력하면 해당 게시글의 내용을 조회할 수 있다.
   * 조회 종료를 원하면 0을 누르면 종료된다.
2. 내 게시글 수정
   * 현재 로그인 하고 있는 유저가 작성한 모든 게시글을 보여준다.
   * 수정을 원하는 게시글 번호를 입력하면 해당 게시글의 제목과 내용을 수정할 수 있다.
   * 수정 종료를 원하면 0을 누르면 종료된다.
3. 내 게시글 삭제
   * 현재 로그인 하고 있는 유저가 작성한 모든 게시글을 보여준다.
   * 삭제을 원하는 게시글 번호를 입력하면 해당 게시글을 삭제할 수 있다.
   * 삭제 종료를 원하면 0을 누르면 종료된다.

#### 종료
* 언제든지 0을 누르면 게시판 프로그램이 종료된다.<br><br>


## Class Diagram (UML)
<!-- <img src="" width="300"> -->
<img src="images/board.jpg" width="650"> <br><br>

## DEMO
