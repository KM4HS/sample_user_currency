# 은행 환전 프로그램
Spring 심화 과정 개인 과제로 제작한 콘솔 기반의 은행 환전 프로그램입니다. 


## 기능
**회원가입/로그인**
- 이메일과 이름을 입력해 신규 유저를 등록할 수 있습니다. 기존 유저와 중복되는 이메일은 사용할 수 없습니다.
- 이메일을 사용해 로그인할 수 있습니다.
- 로그인한 유저의 탈퇴가 가능하고, 탈퇴하면 해당 유저의 환전 요청 기록들은 사라집니다.


**통화 등록과 조회**
- 기본으로 등록된 USD 외에 원하는 통화를 등록할 수 있습니다.
- 로그인하지 않아도 통화의 등록 및 조회가 가능합니다.
- 조회 기능을 통해 통화 id를 확인할 수 있습니다.


**환전 요청**
- 환전을 원하는 금액(krw)과 원하는 통화의 id로 환전 요청을 등록할 수 있습니다.
- ``JPY``, ``IDR``, ``VND``, ``KHR``은 통화 등록시 100 단위로 계산됩니다.
- 환전 요청을 취소할 수 있으며, 요청 상태를 확인할 수 있습니다.
- 현재 로그인한 유저의 환전 요청 횟수와 요청한 총액(krw)을 알 수 있습니다.


## 시작 설정(IntelliJ 기준)
1. ``exchange.sql``을 먼저 실행해주세요.
2. 애플리케이션 시작 전, 구성 편집에 들어가 본인의 db 설정에 맞게 환경 변수를 설정해주세요.
   - ``DB_URL``: {데이터베이스 url}/exchange
   - ``DB_USER``: db 인증 사용자명
   - ``DB_PASSWORD``: db 인증 비밀번호
3. 사용하던 스키마인 경우 기존 테이블을 모두 삭제해주세요.


## API 명세서 & ERD

![CH4 환전 개인 과제](https://github.com/user-attachments/assets/fe3fb15a-cebe-44f0-ad7f-e5c2fa67f6c2)

[API 명세서](https://documenter.getpostman.com/view/39379332/2sAYBXCB8Z)

## 개발 환경
- window11
- JDK 17
- intelliJ IDEA 2024.2.3
- Spring boot 3.3.5
- gradle 8.10.2
- MySql 8.0.40
