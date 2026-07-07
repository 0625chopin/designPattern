package structuralPattrens.proxy.protection;

// [보조] 직책(권한 등급)을 정의한 열거형. 보호 프록시가 접근 권한을 판단하는 기준으로 쓰인다.
// 위에서 아래로 갈수록 낮은 직책 (DIRECTOR > MANAGER > STAFF)
enum RESPONSIBILITY {
    STAFF, // 사원
    MANAGER, // 과장
    DIRECTOR // 상무
}
