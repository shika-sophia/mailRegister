
■FakeSMTP
◆README.md
https://github.com/Nilhcem/FakeSMTP

FakeSMTP is a Free Fake SMTP Server with GUI for testing emails in applications easily. 
It is written in Java.

Configure your application to use localhost as your SMTP server, 
    and all emails will be intercepted and displayed in this software.

FakeSMTP uses SubEthaSMTP: an easy-to-use server-side SMTP library for Java.
FakeSMTP is free to use for commercial and non-commercial projects and the source code is provided.
It is licensed under the very free BSD or GPL license, whichever you prefer.


＊Requirements
You need Java JVM 1.6 or newer installed on your machine.

If you are on a "Unix-like" machine (Mac, GNU/Linux, BSD...),
    you may have to be "root" to start the port 25, otherwise, try another port >= 1024.

＊Usage
The fakeSMTP.jar is auto-executable. If your desktop environment supports it, you can directly double click on the .jar file. Otherwise, run the following command:

>java -jar fakeSMTP-VERSION.jar
If you want to specify the directory where emails will be saved 
    when starting the application, you can use the -o argument:

>java -jar fakeSMTP-VERSION.jar -o output_directory_name
>java -jar fakeSMTP-VERSION.jar --output-dir output_directory_name

If you want to autostart the SMTP server at launch, you can use the -s argument:


>java -jar fakeSMTP-VERSION.jar -s
>java -jar fakeSMTP-VERSION.jar --start-server

If you want to autostart the SMTP server without a GUI (background) on a different port and bound to the loopback address:


>java -jar fakeSMTP-VERSION.jar -s -b -p 2525 -a 127.0.0.1
>java -jar fakeSMTP-VERSION.jar --start-server --background --port 2525 --bind-address 127.0.0.1

If you don't need to save emails on the filesystem (to improve the overall performances), you can use the -m (memory mode) argument:


>java -jar fakeSMTP-VERSION.jar -m

To see all the available options (relay domains, custom eml-viewer...):


>java -jar fakeSMTP-VERSION.jar --help


*Alternatives
FakeSMTP was created because we couldn't find any free (as in freedom) and cross-platform SMTP server with GUI for testing emails in applications or websites. Listed below are some greats alternatives to Fake SMTP:

SMTP4dev

Nice features;
Open source;
Windows only (written in .Net).
DevNull SMTP

Lightweight;
Closed source;
Cross-Platform (written in Java 1.4).
Building it
You need to download and setup Maven. Once installed, go to project directory and run the following command:

mvn package -Dmaven.test.skip
This command will create an executable jar on the target folder.

We recommend you not to skip unit tests.

Once you know how to configure unit tests for this project, stop skipping them.

Running integration tests
To run integration tests, you will first need to launch the application and start the server on port 2525.

java -jar fakeSMTP-VERSION.jar -p 2525 -s
You can then run the following command:

mvn integration-test
Change the default port for unit/integration tests
You need to modify the following file: src/test/java/com/nilhcem/fakesmtp/core/test/TestConfig.java.

Please note that it is better to have two different ports for unit and integrations tests, to avoid any port binding exception while running Maven's integration-test goal.

Usage on Docker
Run distributed version: Dockerfile

`docker build -t="mail" github.com/Nilhcem/FakeSMTP`

`docker run -ti -p 250:25 --privileged=true -v /mail:/output mail`
Build from source

Get sources from GitHub: Dockerfile

git clone https://github.com/Nilhcem/FakeSMTP
cd FakeSMTP
Build the docker image

mvn package docker:build -DskipTests
Run the docker image

docker run -ti -d fakesmtp
Configure container

Map the SMTP port 25 to host:

-p 250:25

Map volume for received mails:

--privileged=true -v /mail-data:/output

Full command

Foward fakesmtp:25 to host port 250,

mount host folder /home/fakesmtp/mail as container folder /output

docker run -ti -d -p 250:25 --privileged=true -v /home/fakesmtp/mail:/output fakesmtp

Contact me
Use my github's nickname (at) gmail (dot) com


◇google翻訳
README.md
偽SMTP
FakeSMTPは、アプリケーションで簡単に電子メールをテストするためのGUIを備えた無料の偽のSMTPサーバーです。それはJavaで書かれています。


localhostSMTPサーバーとして使用するようにアプリケーションを構成すると、すべての電子メールが傍受され、このソフトウェアで表示されます。

FakeSMTPは、Java用の使いやすいサーバー側SMTPライブラリであるSubEthaSMTPを使用します。
FakeSMTPは商用および非商用プロジェクトで自由に使用でき、ソースコードが提供されます。
非常に無料のBSDまたはGPLライセンスの下で、どちらを使用してもライセンスが付与されます。


＊必要条件
マシンにJava JVM 1.6以降がインストールされている必要があります。

「Unixライク」なマシン（Mac、GNU / Linux、BSD ...）を使用している場合、ポートを開始するには「ルート」である必要があります25。そうでない場合は、別のポート> =を試してください1024。

使用法
fakeSMTP.jarは自動実行可能です。デスクトップ環境でサポートされている場合は、.jarファイルを直接ダブルクリックできます。それ以外の場合は、次のコマンドを実行します。

java -jar fakeSMTP-VERSION.jar
アプリケーションの起動時にメールが保存されるディレクトリを指定する場合は、-o引数を使用できます。

java -jar fakeSMTP-VERSION.jar -o output_directory_name
java -jar fakeSMTP-VERSION.jar --output-dir output_directory_name
起動時にSMTPサーバーを自動起動する場合は、次の-s引数を使用できます。

java -jar fakeSMTP-VERSION.jar -s
java -jar fakeSMTP-VERSION.jar --start-server
別のポートでGUI（バックグラウンド）を使わずにSMTPサーバーを自動起動し、ループバックアドレスにバインドする場合：

java -jar fakeSMTP-VERSION.jar -s -b -p 2525 -a 127.0.0.1
java -jar fakeSMTP-VERSION.jar --start-server --background --port 2525 --bind-address 127.0.0.1
（全体的なパフォーマンスを向上させるために）ファイルシステムにメールを保存する必要がない場合は、-m（メモリモード）引数を使用できます。

java -jar fakeSMTP-VERSION.jar -m
使用可能なすべてのオプション（リレードメイン、カスタムeml-viewer ...）を表示するには：

java -jar fakeSMTP-VERSION.jar --help
代替案
FakeSMTPは、アプリケーションやWebサイトで電子メールをテストするためのGUIを備えた（自由のように）無料のクロスプラットフォームSMTPサーバーが見つからなかったために作成されました。以下に、Fake SMTPに代わる優れた方法をいくつか示します。

SMTP4dev

素晴らしい機能。
オープンソース;
Windowsのみ（.Netで記述）。
DevNull SMTP

軽量;
クローズドソース。
クロスプラットフォーム（Java 1.4で記述）。
それを構築する
Mavenをダウンロードしてセットアップする必要があります。インストールしたら、プロジェクトディレクトリに移動し、次のコマンドを実行します。

mvn package -Dmaven.test.skip
このコマンドは、ターゲットフォルダーに実行可能なjarを作成します。

単体テストをスキップしないことをお勧めします。

このプロジェクトの単体テストの構成方法がわかったら、それらをスキップしないでください。

統合テストの実行
統合テストを実行するには、最初にアプリケーションを起動し、ポートでサーバーを起動する必要があります2525。

java -jar fakeSMTP-VERSION.jar -p 2525 -s
その後、次のコマンドを実行できます。

mvn integration-test
ユニット/統合テストのデフォルトポートを変更する
次のファイルを変更する必要があります： src/test/java/com/nilhcem/fakesmtp/core/test/TestConfig.java。

Mavenのintegration-test目標の実行中にポートバインディングの例外を回避するために、単体テストと統合テストには2つの異なるポートを用意することをお勧めします。

Dockerでの使用
分散バージョンを実行する：Dockerfile

`docker build -t="mail" github.com/Nilhcem/FakeSMTP`

`docker run -ti -p 250:25 --privileged=true -v /mail:/output mail`
ソースからビルド

GitHubからソースを取得する：Dockerfile

git clone https://github.com/Nilhcem/FakeSMTP
cd FakeSMTP
Dockerイメージをビルドする

mvn package docker:build -DskipTests
Dockerイメージを実行する

docker run -ti -d fakesmtp
コンテナーを構成する

SMTPポート25をホストにマッピングします。

-p 250:25

受信メールの地図ボリューム：

--privileged=true -v /mail-data:/output

完全なコマンド

Foward fakesmtp：25をホストポート250に、

ホストフォルダー/ home / fakesmtp / mailをコンテナーフォルダー/ outputとしてマウントする

docker run -ti -d -p 250:25 --privileged=true -v /home/fakesmtp/mail:/output fakesmtp

私に連絡して
私のgithubのニックネーム（at）gmail（dot）comを使用します


