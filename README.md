# SpringSession

Django→Spring Boot 파일럿 세션에서 만든 게시글(Post) API 프로젝트입니다.

## 실행 방법

1. 로컬 MySQL에 `db-setup.sql`을 실행해 `likelion_blog` DB와 `likelion` 계정을 만듭니다.
2. `DB_PASSWORD` 환경변수를 설정합니다 (`src/main/resources/application.yaml`이 이 값을 읽습니다).
   ```bash
   export DB_PASSWORD=Likelion2026!
   ./gradlew bootRun
   ```
   IntelliJ에서 실행할 경우 Run Configuration의 Environment variables에 `DB_PASSWORD=Likelion2026!`을 추가합니다.

---

# 2주차 과제 — 하나의 Entity, 두 가지 DTO

`Post` Entity 하나를 목적이 다른 두 응답으로 나눠서 사용합니다.

| DTO | 용도 | 필드 |
| --- | --- | --- |
| `PostSummaryResponse` | 게시글 목록 화면 | `id`, `title`, `createdAt` |
| `PostDetailResponse` | 게시글 상세 화면 | `id`, `title`, `content`, `createdAt` |

## 두 DTO의 필드가 다른 이유

목록 화면은 게시글이 여러 건 한 번에 내려가는 화면이라 본문(`content`)까지 보여줄 필요가 없습니다. 반면 상세 화면은 게시글 한 건을 자세히 보여주는 화면이라 본문이 반드시 있어야 합니다. 즉 두 DTO는 **DB 조회를 다르게 최적화하기 위해서가 아니라, 화면(응답)마다 실제로 필요한 데이터의 모양이 다르기 때문에** 나뉩니다.

`Post` Entity는 그대로 두고 DTO만 두 개로 나눴기 때문에, 나중에 목록 화면에 필드가 하나 더 필요해지거나 상세 화면의 응답 형태가 바뀌어도 `Post` Entity나 DB 테이블 구조를 건드릴 필요가 없습니다. Entity(DB와 매핑되는 구조)와 Response(외부에 보여줄 구조)가 분리되어 있기 때문입니다.

`PostService.getPostSummaries()`와 `getPostDetails()` 모두 내부적으로는 `postRepository.findAll()`로 `Post` 전체(= content 포함)를 조회합니다. 다만 `PostSummaryResponse`를 만들 때 `content`를 담지 않을 뿐, DB에서 그 컬럼을 아예 조회하지 않는 것은 아닙니다. 조회 컬럼 자체를 줄이는 최적화는 이번 범위가 아닙니다.
