package com.cos.reactivetest;

// WebFlux = ���� ������, �񵿱� + Stream�� ���� �������Ű� ����� �����͸�ŭ ������ ������ �����ϴ� + ������ �Һ� ������ ������ ����
// SSE ����(Servlet, WebFlux �� �� ����) = ������ �Һ� ������ Stream�� ��� ����
public class App{
	public static void main(String[] args) {
		MyPub pub = new MyPub(); // �ۺ��� ����
		MySub sub = new MySub(); // ����ũ���̹� ����

		pub.subscribe(sub);
	}

}
