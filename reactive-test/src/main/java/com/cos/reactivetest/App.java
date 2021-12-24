package com.cos.reactivetest;

// WebFlux = 단일 스레드, 비동기 + Stream을 통해 백프레셔가 적용된 데이터만큼 간헐적 응답이 가능하다 + 데이터 소비가 끝나면 응답이 종료
// SSE 적용(Servlet, WebFlux 둘 다 동작) = 데이터 소비가 끝나도 Stream은 계속 유지
public class App{
	public static void main(String[] args) {
		MyPub pub = new MyPub(); // 퍼블리셔 생성
		MySub sub = new MySub(); // 섭스크라이버 생성

		pub.subscribe(sub);
	}

}
