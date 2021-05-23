# ANYWHERE
## Low-floor bus reservation system for the weak.  
> JunctionX Seoul 2021  

<br/>

## 🍀 Team

👩🏻‍✈️ (Captain)

## 👨🏻‍💻 Overview  
The use of the transport system by the weak should be guaranteed by rights, not welfare.  
As time goes by, the number of vulnerable people is increasing, but people's perceptions and systems are not improving. The low-floor bus system is designed and operated for the weak in transportation, but the disabled person and weak people are not comfortably using the bus.  
The low-floor bus reservation system currently in place allows reservations by phone or text, but such services are not available to the weak with language and speech impairments.  
To compensate for these inconveniences, our team planned a simple and intuitive low-floor bus reservation system using the application.


<br/>

## 🔧 Tech

OS :  
```
Android (SDK : 30)
```

BE(Back-End) :
```
Java
```

Database :
```
Firebase
```

<br/>


## 🏃‍♂️ Getting Started

~~~bash

python3 app.py

~~~  

<br/> 


## 📖 Comment  

> Need 'Telegram bot' Access Token and link point  

본 프로젝트에서는 Python3로 작성 된 블록체인에 저장 되어 있는 이미지 객체를 텔레그램으로 전송합니다.  
전송 방법은 Telegram에서 제공하는 [Bot API](https://core.telegram.org/bots)를 사용해서 전송하기 때문에, 개별적인 [Access Token](https://gabrielkim.tistory.com/entry/Telegram-Bot-Token-%EB%B0%8F-Chat-Id-%EC%96%BB%EA%B8%B0)과 백앤드와 Telegram을 연결하는 파일(Link point)가 필요합니다.  

<br/>

> Syntax


1. import telegram and set Bot auth
~~~python

import telegram
bot = telegram.Bot(token='your token')
token = 'your token'
chat_id = your chat_id

~~~


2. How to send img

~~~python

from io import BytesIO
from PIL import Image

# Load encoded file using pickle module
convtImg = pickle.loads(base64.b64decode(convImg))
converted_img = Image.fromarray(convtImg, 'RGB')

# Save img object into created BytesIO container
bio = BytesIO()
bio.name = str(uuid.uuid4())
converted_img.save(bio, 'JPEG')
bio.seek(0)

# Send Bytes object to telegram
bot.sendPhoto(chat_id=chat_id, photo=bio)

~~~

<br />  

> Methodology

1. Get block filtered by timestamp

~~~python

list(filter(lambda x: x['timestamp'] > time1 and x['timestamp'] < time2, blockchain.chain))

~~~