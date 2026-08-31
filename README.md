# 🎵 정신줄 꽉 JAVA (Java Swing Music Player)

## 🐯 호랑이가 담배 피우던 시절... (AI가 할루시네이션만 하던 순수 노가다 시절)
AI가 세상을 지배하기 훨씬 전, 오롯이 인간의 깡다구와 구글링, 그리고 밤샘 커피만으로 완성했던 2학년 첫 팀 프로젝트입니다.
그 시절 우리는 ChatGPT도 없이 순수 자바(Java) 백과사전과 맨땅에 헤딩하는 심정으로 이 플레이어를 만들었습니다. 
버려진 코드와 눈물(?)이 난무했지만, 그만큼 코딩의 기초 체력을 단단히 다져준 소중한 결과물입니다.
<br>
팀 이름도 정신줄 꽉 JAVA인 이유도.. 이 때문..
<br>
(용량 이슈로 노래 파일 업로드 불가)

<br>

https://github.com/user-attachments/assets/368c0f57-3ec1-4fc7-a8f4-74b7ba284b24

<br>

## 🚀 주요 기능
* **Java Swing 기반 UI:** 직관적인 플레이어 인터페이스와 재생, 일시 정지, 재시작 제어 구현
* **다중 스레드(Thread) 동기화:** 오디오 재생과 Progress Bar(진행 바)를 실시간으로 맞추기 위해 구현한 멀티스레딩
* **외부 웹 연동:** 앨범 표지나 가수 이름을 누르면 관련 웹페이지로 날아가는 하이퍼링크 기능
* **가사 뷰어:** 스크롤 가능한 별도의 창으로 가사 화면 제공

<br>

## 🛠 개발 환경 및 기술 스택
* **Language:** `Java`
* **GUI Framework:** `Java Swing`
* **Audio Handling:** `javax.sound.sampled` (`Clip`, `AudioInputStream`)
