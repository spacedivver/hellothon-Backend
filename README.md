# ✉️노인의 편지
## 프로젝트 개요
elice 주관 AI-hellothon 해커톤에서 진행한 프로젝트로 MVP 개발을 통해 핵심 기능만을 우선적으로 구현

독거노인을 위한 AI 기반 말동무 역할을 하면서, 자녀에게 홀로계신 부모님의 일상을 자연스럽게 전달하는 서비스

## 개발 배경
- 노년 중 독거노인 층에서 외로움이라는 문제는 상당히 심각한 문제가 되고 있고, 대한민국 독거노인의 비율은 매년 증가하는 추세
- 심리적 고립과 건강 악화로 이어지며, 이는 사회적 비용 증가로도 연결
- 위 문제들을 디지털 솔루션을 통해 해결하고자 함

## ⚙️ 기술스택
Java, Spring, Mysql, React, Pyhton,

주관사 elice에서 제공된 Onedemand 클라우드 인스턴스, ML API,

Navercloud API

## 🎞️데모 화면


![hellothon그림1](https://github.com/user-attachments/assets/06d2ecc1-8301-462f-ba93-22cba683a67a)
![hellothon그림2](https://github.com/user-attachments/assets/d5a1dfe7-bdf4-4bab-bd93-cc0fd2b5e614)

![hellothon그림3](https://github.com/user-attachments/assets/2e568514-829d-4b5c-aeac-c373f53d10fb)



## 🛠️기능 설명
1. 앱 푸시 알림으로 노인 사용자에게 알림 내용 전송
2. 음성을 통해 일상이나 특정 일정에 대한 내용을 대화
3. 해당 대화를 바탕으로 키워드와 상황을 정리 후 자녀들에게 일정 시간에 전송

## 💻구현 내용
처음 기획은 ML API 내 Interlingual TTS를 이용하여 자녀의 목소리로 커스텀하여 음성 출력을 구현하려함

하지만, 서버 응답 속도가 현저히 느려 NaverCloude tts API로 변경하여 주어진 특정 음성 선택 후 음성 텍스트 추출 구현

google stt API를 통한 사용자 음성을 텍스트 입력

옵션으로 출력 음성 커스텀을 위한 기능을 ML API 내 Interlingual TTS를 사용하여 구현
