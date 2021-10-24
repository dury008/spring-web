package kr.ko.dury008.configuration.http;

public enum BaseResponseCode {//성공/실패 등에 대하여 에러 메세지코드를 ENUM으로 관리, 메세지 프로퍼티와 1:1로 사용해야함

   SUCCESS, // 성공
   ERROR, //에러
   DATA_IS_NULL, //NULL
   LOGIN_REQUIRED,
   UPLOAD_FILE_IS_NULL,
   VALIDATE_REQUIRED// 필수체크
   ;
   
   
}