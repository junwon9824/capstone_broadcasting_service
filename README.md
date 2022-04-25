# al_ddeul_sin_bang
스마트 마을 방송 시스템


<hr>

### REST API URI

#### USER Table
|METHOD|URI|설명|
|--|--|--|
|GET|/users|모든 유저 조회|
|POST|/users|유저 생성|
|GET|/users/{id}|특정 유저 조회|
|DELETE|/users/{id}|유저 삭제|
|PUT|/users/{id}|유저 수정|
|PATCH|/users-admins/{id}|이장으로 변경|
|GET|/users/{id}/device|유저의 단말기 정보 조회|
|GET|/users/{id}/village|유저의 마을 정보 조회|

#### ADMIN Table
|METHOD|URI|설명|
|--|--|--|
|GET|/admins|모든 이장 조회|
|GET|/admins/{id}|특정 이장 조회|
|DELETE|/admins/{id}|이장 삭제|
|PUT|/admins/{id}|이장 수정|
|PATCH|/admins-users/{id}|회원으로 변경|

#### VILLAGE Table
|METHOD|URI|설명|
|--|--|--|
|GET|/villages|모든 마을 조회|
|GET|/villages/{id}|특정 마을 조회|
|GET|/villages/{id}/devices|마을 내 단말기 조회|
|POST|/villages/{id}/admins|마을 이장 등록|
|PUT|/villages/{id}/admins|마을 이장 변경|
|DELETE|/villages/{id}/admins|마을 이장 삭제|

#### DEVICE Table
|METHOD|URI|설명|
|--|--|--|
|GET|/devices|모든 단말기 조회|
|POST|/devices|단말기 생성|
|DELETE|/devices/{id}|특정 단말기 삭제|
|PUT|/devices/{id}|단말기 정보 수정|
|GET|/devices/{id}|특정 단말기 조회|
