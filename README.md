<div align="center">

### 배포 
https://daisy.wisoft.io/project/timetable/
<br/>
### Database2 Readme.md ✅

<img src="https://img.shields.io/badge/-readme.md-important?style=flat&logo=google-chrome&logoColor=white" /> <img src="https://img.shields.io/badge/-tech blog-blue?style=flat&logo=google-chrome&logoColor=white" /> <img src="https://img.shields.io/badge/release-v0.0.0-yellow?style=flat&logo=google-chrome&logoColor=white" />
<br/> <img src="https://img.shields.io/badge/Project Period-2025.03.14~2025.06.20-green?style=flat&logo=&logoColor=white" />
</div>

</div>

## 📝 소개

2025 Database2 수업 팀 프로젝트입니다.

- 단체 시간표 관리 시스템
: 자신의 시간표를 등록하고 일정 사용자와 그룹을 만들면, <br />
시간표를 겹쳐주어 미팅이나 세미나 일정을 한 눈에 확인할 수 있는 시스템.

</br>
 
### 📌 사용 목적
•	그룹 시간표에서 겹치는 시간을 한눈에 파악할 수 있도록 시각화 </br>
•	회의나 협업 가능 시간을 찾기 쉽게 만들기 위한 디자인   </br>
•	일정 충돌 방지 및 가시성 향상    </br>


<br />

### 🗓️ 화면 구성
<img width="1000" alt="image" src="https://github.com/user-attachments/assets/ce30cd4c-ed21-43b4-b1e7-5ebba1ac938e" />

</br>

#### <시간표 겹침 강조 기능>
<img width="523" alt="overlap-example" src="https://github.com/user-attachments/assets/ee782baf-804d-4381-b36b-4567b8d3c7f1" />

> 📌 **겹치는 시간대는 배경색을 진하게 표시하여 시각적으로 표현합니다.**

### ✅ 겹침 예시

| 학생 | 요일 | 시작 | 종료 | 겹침 여부 |
|------|------|------|------|-------------|
| 홍길동 | 월 | 09:00 | 11:00 | ✅ 김철수와 겹침 |
| 김철수 | 월 | 10:00 | 12:00 | ✅ 홍길동과 겹침 |
| 이영희 | 월 | 13:00 | 14:00 | ❌ 겹치지 않음 |

<br />

#### <특정 학생 시간표 조회/수정/삭제>
<img width="356" alt="image" src="https://github.com/user-attachments/assets/17cccf2c-e1ee-46db-9a4d-49d20a377da5" />
<br />

## 🗂️ APIs
Postman 사용

## 📘 User API

### 🔹 `/api/users`

| 메서드      | URL                       | 설명           | 요청 바디                                       | 응답 예시            |
| -------- | ------------------------- | ------------ | ------------------------------------------- | ---------------- |
| `POST`   | `/api/users`              | 사용자 등록       | `{ "userNumber": int, "userName": string }` | 등록된 사용자 JSON     |
| `GET`    | `/api/users`              | 전체 사용자 목록 조회 | 없음                                          | 사용자 리스트 JSON     |
| `GET`    | `/api/users/{userNumber}` | 특정 사용자 조회    | 없음                                          | 사용자 JSON or 404  |
| `DELETE` | `/api/users/{userNumber}` | 사용자 삭제       | 없음                                          | `"사용자 정보 삭제 성공"` |

---

## 📘 Timetable API

### 🔹 `/api/timetables`

| 메서드      | URL                                       | 설명                  | 요청 바디 / 파라미터                                                                                       | 응답 예시           |
| -------- | ----------------------------------------- | ------------------- | -------------------------------------------------------------------------------------------------- | --------------- |
| `POST`   | `/api/timetables`                         | 시간표 등록              | `{ "week": int, "day": string, "startTime": "HH:mm:ss", "endTime": "HH:mm:ss", "studentId": int }` | 등록된 시간표 JSON    |
| `GET`    | `/api/timetables`                         | 전체 시간표 조회           | 없음                                                                                                 | 시간표 리스트 JSON    |
| `GET`    | `/api/timetables/{id}`                    | 특정 학생 시간표 조회        | `id`: 학생 번호                                                                                        | 시간표 리스트 JSON    |
| `GET`    | `/api/timetables/{id}/search/day?day=월`   | 특정 학생의 특정 요일 시간표 조회 | 파라미터: `day`                                                                                        | 시간표 JSON        |
| `GET`    | `/api/timetables/{id}/search/week?week=2` | 특정 학생의 특정 주차 시간표 조회 | 파라미터: `week`                                                                                       | 시간표 JSON        |
| `GET`    | `/api/timetables/search/day?day=화`        | 모든 학생의 특정 요일 시간표 조회 | 파라미터: `day`                                                                                        | 시간표 리스트 JSON    |
| `PATCH`  | `/api/timetables/{id}/search?day=월`       | 특정 학생의 특정 요일 시간표 수정 | 바디에 수정 정보 포함                                                                                       | 수정 건 수          |
| `PATCH`  | `/api/timetables/{id}`                    | 특정 학생의 시간 수정        | `{ week, day, startTime, endTime }`                                                                | 수정 건 수          |
| `DELETE` | `/api/timetables/{id}`                    | 특정 학생의 시간표 전체 삭제    | 없음                                                                                                 | `"고객 정보 삭제 성공"` |
| `DELETE` | `/api/timetables/{id}/detail`             | 특정 학생의 특정 시간표 삭제    | `{ week, day, startTime, endTime }`                                                                | `"시간표 삭제 성공"`   |

---

## 📊 요청 예시

<details>
<summary><strong>사용자 등록</strong></summary>

```json
POST /api/users
{
  "userNumber": 20230001,
  "userName": "홍길동"
}
```

</details>

<details>
<summary><strong>시간표 등록</strong></summary>

```json
POST /api/timetables
{
  "week": 1,
  "day": "월",
  "startTime": "09:00:00",
  "endTime": "11:00:00",
  "studentId": 20230001
}
```

</details>

<br />


<br />

## ⚙ 기술 스택

### Back-end

<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Java.png?raw=true" width="80">

### Tools

<div>
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Github.png?raw=true" width="80">
<img src="https://github.com/yewon-Noh/readme-template/blob/main/skills/Notion.png?raw=true" width="80">
</div>

<br />


## 💁‍♂️ 프로젝트 팀원
|Backend|Backend|                   Backend                    |
|:---:|:---:|:--------------------------------------------:|
| ![](https://github.com/Yu-Jaeyoung.png?size=120) | ![](https://github.com/Boyeon-Shin.png?size=120) | ![](https://github.com/whyenniii.png?size=120) |
|[유재영](https://github.com/Yu-Jaeyoung)|[신보연](https://github.com/Boyeon-Shin)|     [임예은](https://github.com/whyenniii)      |
