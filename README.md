# al_ddeul_sin_bang
스마트 마을 방송 시스템


<hr>

### REST API URI

<details>
<summary>리스트 펼치기</summary>
<div markdown="1">

#### uri prefix : /api 

#### USER Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/users|모든 유저 조회||
|POST|/users|유저 생성|username, email|
|GET|/users/{email}|특정 유저 조회||
|DELETE|/users/{id}|유저 삭제||
|PUT|/users/admins/{id}|이장으로 변경||
|GET|/users/{id}/devices|유저의 단말기 정보 조회||
|GET|/users/{id}/villages|유저의 마을 정보 조회||
|POST|/users/{id}/villages|유저 마을 구독|villageId|
|GET|/users/{id}/ward|유저의 피보호자 조회|||
|POST|/users/{id}/guardian|유저의 보호자 등록|guardianId|||

#### ADMIN Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/admins|모든 이장 조회||
|GET|/admins/{id}|특정 이장 조회||
|DELETE|/admins/{id}|이장 삭제||
|PUT|/admins/users/{id}|회원으로 변경||
|POST|/admins/{id}/files|방송 등록|villageId, title, contents|
|GET|/admins/{id}/files|등록한 방송 조회||
|GET|/admins/{id}/villages|관리중인 마을 조회||

#### VILLAGE Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/villages|모든 마을 조회||
|POST|/villages|마을 등록|nickname, state, city, town|
|GET|/villages/{id}|특정 마을 조회||
|GET|/villages/{id}/devices|마을 내 단말기 조회||
|POST|/villages/{id}/admins|마을 이장 등록|adminId|
|PUT|/villages/{id}/admins|마을 이장 변경||
|DELETE|/villages/{id}/admins|마을 이장 삭제||
|GET|/villages/{id}/files|마을 방송목록 조회||
|GET|/villages/{id}/users|마을 구독중인 회원목록 조회||

#### DEVICE Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/devices|모든 단말기 조회||
|POST|/devices|단말기 생성|memberId, villageId|
|DELETE|/devices/{id}|특정 단말기 삭제||
|PUT|/devices/{id}|단말기 정보 수정|memberId, villageId|
|GET|/devices/{id}|특정 단말기 조회||

</div>
</details>
  
<hr>

### DEVICE<->SERVER MESSAGE FORMAT

<details>
<summary>리스트 펼치기</summary>
<div markdown="1">
  
  #### [SERVER -> DEVICE]
  
  #### 방송 파일
  ```
  송신자/제목/내용/FILE_ID
  -> 송신자 : MASTER -> 이장
  ```
  #### 초기 세팅 응답 메세지
  ```
  등록 실패 : LOGIN/-1
  등록 성공 : LOGIN/DEVICE_ID/USERNAME
  ```
  
  #### [DEVICE -> SERVER]
  
  #### 초기 세팅 메세지
  ```
  LOGIN/PHONE_NUMBER
  ```
  
  #### 긴급 호출
  ```
  URGENT/DEVICE_ID
  ```
  #### 감지 데이터  
  ```
  DETECT/DEVICE_ID/온도/습도/지진 감지/가스 누출 여부/이상행동 감지 여부
  ```
  #### 방송 응답 메세지
  ```
  REPLY/DEVICE_ID/방송 제목/응답 종류/FILE_ID
  -> 응답 종류 : 0 -> 방송 정상 수신
  -> 응답 종류 : 1 -> 방송 확인
  ```
  
</div>
</details>
  
