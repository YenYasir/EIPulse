# EIPulse
EIPulse EEIT71 Project
## 開發人員
## 系統環境
jse17 、tomcat 10.1.3、servlet 5.0 、mysql、maven3.9.4 、hibernate6.2.7
## 開發環境
Eclipse 2023-06 、MySQL 8.0.34
## 雲端環境
## 專案檔建置說明
1. src.zip   專案檔案
2. pom.xml   maven 環境建置檔
使用Eclipse做專案建置，選擇new新建dynamic web project，專案名右鍵選擇configure convert to maven project，將pom.xml檔案的dependecies 複製到專案裡的pom.xml
![pom](https://github.com/YenYasir/EIPulse/assets/133478155/02e7be59-4547-4450-98cb-a7d20d314f2e)

將src資料夾內的檔案，複製至新專案相同位置，選擇 overwrite all
設定tomcat ，選擇 server，選apache ->　10.1 -> next ，browse >選擇tomcat 10.1.13資料夾 ，finish 

啟動server 


## 功能設計
 - [x] 登入介面
 - [x] 修改密碼
 - [ ] 員工權限
 - [x] 員工人事表增刪查改
 - [x] 登出

## 更新日誌
分支名：wang
更新日期：112/9/9
更新事項：修改三個JSP版面及三個CSS(login、index、loginerror)

分支名：Jia
更新日期：112/9/9
更新事項：修改三個JSP版面及三個CSS(forgotpwd、newpwd、enterotp)

分支名：wang
更新日期：112/9/10
更新事項：更新員工新增畫面，將上下捲動修改為下一頁顯示(insertemp.jsp、insertemp.css)

分支名：develop
更新日期：112/9/10
更新事項：更新Bean與加上映君&彥宇&懿珈的更新(0910-23-30 src.zip)

分支名：YanYu
更新日期：112/9/11
更新事項：更新insert ,selectbyid .jsp 表單驗證
