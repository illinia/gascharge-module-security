# gascharge-module-security

spring boot oauth2-client, security, jwt 포함한 시큐리티 관련 모듈

* Domain User, 직접 정의한 UserPrinciple 을 사용하여 유저 인증, 인가 관리
* /config/SecurityConfig 클래스에서 @EnableWebSecurity 어노테이션 활성화, 전반적인 설정 관리
* 인증된 사용자 id 를 컨텍스트에 저장하는 OncePerRequestFilter 필터를 상속받은 필터 사용(/filter/TokenAuthenticationFilter)
* 소셜 로그인 사용(Google, Kakao, Naver)
* Jwt 암호화, 복호화, 유효성 검사

*common-common, domain-reservation 모듈 의존, 독립적으로 실행 불가능*

로컬, 원격 메이븐 레포지토리
```groovy
implementation 'com.gascharge.taemin:gascharge-module-security:0.0.1-SNAPSHOT'
```

멀티 모듈 프로젝트
```groovy
// settings.gradle
includeProject("security", "module")
```
```groovy
// build.gradle
implementation project(":gascharge-module-security")
```

YAML 파일 설정은 https://github.com/illinia/gascharge-module-yml 참조