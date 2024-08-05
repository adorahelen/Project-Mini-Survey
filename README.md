# 미니 프로젝트

## 목차 : 
1. 요구사항 정의하기
2. 기능 목록 
3. 화면 흐름도 
4. 화면 레이아웃 (콘솔 창 돌아가는거 캡쳐)
5. 클래스 다이어그램
6. 테이블 목록
7. 테이블 정의서
8. ERD
9. Source code

## 요구사항 명세서
1) 회원은 아이디, 비밀번호, 이름, 이메일, 사진, 성별, 가입일자로 구성된다.
2) 회원은 비밀번호 변경, 회원정보 수정, 회원 정보 조회 및 탈퇴가 가능하다.
3) 관리자는 전체 회원 목록을 볼 수 있고, 회원 정보의 조회 및 수정과 삭제가 가능하다.
4) 설문은 설문번호, 제목, 항목1, 항목2, 항목1의 득표수, 항목2의 득표수, 시작일, 종료일, 등록일, 수정일로 구성
5) 설문은 매주 월요일 0시에 시작하여 일요일 밤에 종료되고, 예약 등록이 가능하다.
6) 설문은 동시에 진행이 불가능
7) 설문 참여는 회원만 가능
8) 설문의 등록, 수정, 삭제는 관리자만 가능하다.
9) 회원은 자신이 참여한 설문을 볼 수 있고, 재투표는 불가능하다.
10) 설문참여는 설문번호, 참여한 아이디, 선택항목, 설문참여일로 구성된다.

## 기능 목록
- 설문 목록
- 참여한 설문 목록
- 설문 보기
- 설문 참여
- 설문 등록
- 설문 수정
- 설문 삭제
<img width="800" alt="image" src="https://github.com/user-attachments/assets/c86443c3-011c-4275-ae7c-754e7a0fe5bf">


## 화면 흐름도 
<img width="800" alt="image" src="https://github.com/user-attachments/assets/373e1e17-0edb-44e6-846b-e8d91fc62cc2">

## 화면 레이아웃 
<img width="500" alt="image" src="https://github.com/user-attachments/assets/cff520a3-70fa-4996-beaf-faebd3e94609">
<img width="800" alt="image" src="https://github.com/user-attachments/assets/4d0d02eb-d404-405c-b83c-1a8a1fae37e4">


## 클래스 다이어그램
<img width="800" alt="image" src="https://github.com/user-attachments/assets/8969630b-9883-42ae-b978-e76531ebc941">

## 테이블 목록
<img width="500" alt="image" src="https://github.com/user-attachments/assets/30a0c91a-4dfb-4b4f-b84a-200e945e2b47">

## 테이블 정의서
t_servey
설문번호 / sno / int /        nn / pk / auto_increment
설문제목 / title / varchar(100) / nn
설문항목1 / one / varchar(100) / nn
설문항목2 / two / varchar(100) / nn
설문항목1득표수 / one_cnt / int
설문항목2득표수 / two_cnt / int
설문시작일 / start_date / date
설문종료일 / end_date / date
등록일 / reg_date / date / nn
수정일 / mod_date / date
t_vote
설문번호 : sno / int / nn / pk / fk
아이디 : pid / varchar(20) / nn / fk
선택 항목 : choice / int
설문 참여일 : vote_date / date



## ERD 
<img width="800" alt="image" src="https://github.com/user-attachments/assets/b737f645-803c-49b0-8a2b-62851d1048a3">
<img width="700" alt="image" src="https://github.com/user-attachments/assets/4cf1e484-a5b8-4467-b521-d310bce9a3ba">


