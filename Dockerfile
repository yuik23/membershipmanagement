#ベースイメージを指定 debian:Linuxディストリビューション
FROM mysql:8.0-debian
#対応するディストリビューションの実行コマンドを入力して必要なライブラリなどのインストールを行う
#パッケージリストを更新しより新しいバージョンのパッケージをインストール
RUN apt-get update
#多国語サポート用ライブラリ（locales）インストール。問い合わせがあった場合はすべて「y」と答える
RUN apt-get -y install locales-all
#環境変数 ja_JP.UTF-8を利用する宣言をする
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8
#./conf/mysql/my.cnfを/etc/my.cnfへコピー
COPY ./conf/mysql/my.cnf /etc/my.cnf
