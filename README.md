# 塾の会員管理APIの概要

- このプロジェクトは小中学生対象、会員数40人規模の塾で使用することを想定した会員管理アプリの作成を最終目標としています。
- まず最低限memberテーブルのデータに関してCRUD処理を実装し、余力があればaccessesテーブルのデータに関してのCRUD処理、UIをReactで実装の順に進めていきたいと思っています。
- READMEは試行錯誤中なので適宜修正を加えていきます。
- 現在READMEに追加したいと思っていること
- [ ] 使用している主な技術
- [ ] ディレクトリ構成

## APIの概要

### API仕様書

https://yuik23.github.io/membership-management-api-doc

### データベース定義

**members**
| カラム名（論理名） | カラム名（物理名） | 型・桁 | Nullable | その他コメント |
| --- | --- | --- | --- | --- |
| ID | id | int | NO | Primary key, Auto increment |
| 名前 | name | varchar(255) | NO | |
| 生年月日 | birthdate | date | NO | YYYY-MM-DD 形式 |
| 入会日 | enrollment_date | date | NO | YYYY-MM-DD 形式 |
| 学校名 | school_name | varchar(255) | NO | |
| 学年 | grade | int | NO | |
| 更新日時 | updated_at | datetime | NO | YYYY-MM-DD HH:MM:SS形式 |

**accesses**
| カラム名（論理名） | カラム名（物理名） | 型・桁 | Nullable | その他コメント |
| --- | --- | --- | --- | --- |
| ID | id | int | NO | Primary key, Auto increment |
| 入室時間 | entry_time | datetime | NO | YYYY-MM-DD HH:MM 形式 |
| 退室時間 | exit_time | datetime | YES | YYYY-MM-DD HH:MM 形式 |
| 在室時間 | total_time | time | YES | HH:MM 形式 |
| メンバーID | member_id | int | | 外部キー |
| 更新日時 | updated_at | datetime | NO | YYYY-MM-DD HH:MM:SS形式 |

