# 测试


<a name="overview"></a>
## 概览
测试描述


### 版本信息
*版本* : 1.0


### 许可信息
*服务条款* : http://localhost:8080/


### URI scheme
*域名* : localhost:8080  
*基础路径* : /


### 标签

* user-controller : 用戶




<a name="paths"></a>
## 资源

<a name="user-controller_resource"></a>
### User-controller
用戶


<a name="getinfosusingget"></a>
#### 获取用户列表信息
```
GET /users
```


##### 说明
根据url的id来获取用户列表信息


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«List«user»»](#ac84df2c73d09727d02dce3e95f66e79)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/users
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : [ {
    "age" : 0,
    "email" : "string",
    "id" : 0,
    "name" : "string"
  } ],
  "message" : "string"
}
```


<a name="getinfousingget"></a>
#### 获取用户详细信息
```
GET /users/{id}
```


##### 说明
根据url的id来获取用户详细信息


##### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Body**|**id**  <br>*必填*|用户id|string|


##### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«user»](#7fc848851d4397b4476e7ae42fabba96)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


##### 消耗

* `application/json`


##### 生成

* `*/*`


##### HTTP请求示例

###### 请求 path
```
/users/{id}
```


###### 请求 body
```
json :
{ }
```


##### HTTP响应示例

###### 响应 200
```
json :
{
  "code" : "string",
  "data" : {
    "age" : 0,
    "email" : "string",
    "id" : 0,
    "name" : "string"
  },
  "message" : "string"
}
```




<a name="definitions"></a>
## 定义

<a name="user"></a>
### user

|名称|说明|类型|
|---|---|---|
|**age**  <br>*可选*|年齡  <br>**样例** : `0`|integer (int32)|
|**email**  <br>*可选*|电子邮件  <br>**样例** : `"string"`|string|
|**id**  <br>*可选*|id  <br>**样例** : `0`|integer (int64)|
|**name**  <br>*可选*|名字  <br>**样例** : `"string"`|string|


<a name="ac84df2c73d09727d02dce3e95f66e79"></a>
### 返回信息«List«user»»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|返回码  <br>**样例** : `"string"`|string|
|**data**  <br>*可选*|信息  <br>**样例** : `[ "[user](#user)" ]`|< [user](#user) > array|
|**message**  <br>*可选*|描述  <br>**样例** : `"string"`|string|


<a name="7fc848851d4397b4476e7ae42fabba96"></a>
### 返回信息«user»

|名称|说明|类型|
|---|---|---|
|**code**  <br>*可选*|返回码  <br>**样例** : `"string"`|string|
|**data**  <br>*可选*|信息  <br>**样例** : `"[user](#user)"`|[user](#user)|
|**message**  <br>*可选*|描述  <br>**样例** : `"string"`|string|





