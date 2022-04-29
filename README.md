# al_ddeul_sin_bang
스마트 마을 방송 시스템


<hr>

### REST API URI

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

#### ADMIN Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/admins|모든 이장 조회||
|GET|/admins/{id}|특정 이장 조회||
|DELETE|/admins/{id}|이장 삭제||
|PUT|/admins/users/{id}|회원으로 변경||
|POST|/admins/{id}/files|방송 등록|villageId, contents|

#### VILLAGE Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/villages|모든 마을 조회||
|GET|/villages/{id}|특정 마을 조회||
|GET|/villages/{id}/devices|마을 내 단말기 조회||
|POST|/villages/{id}/admins|마을 이장 등록||
|PUT|/villages/{id}/admins|마을 이장 변경||
|DELETE|/villages/{id}/admins|마을 이장 삭제||

#### DEVICE Table
|METHOD|URI|설명|REQUEST DATA|
|--|--|--|--|
|GET|/devices|모든 단말기 조회||
|POST|/devices|단말기 생성|memberId, villageId|
|DELETE|/devices/{id}|특정 단말기 삭제||
|PUT|/devices/{id}|단말기 정보 수정|memberId, villageId|
|GET|/devices/{id}|특정 단말기 조회||
