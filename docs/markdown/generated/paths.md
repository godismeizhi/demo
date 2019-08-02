
<a name="paths"></a>
## 路径

<a name="getinfosusingget"></a>
### /list
```
GET /tests/list
```


#### 说明
根据url的id来获取用户列表信息


#### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«List«user»»](#ac84df2c73d09727d02dce3e95f66e79)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


#### 消耗

* `application/json`


#### 生成

* `*/*`


#### 标签

* 测试接口
* 获取用户列表信息2


#### HTTP请求示例

##### 请求 path
```
/tests/list
```


#### HTTP响应示例

##### 响应 200
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
### users/{id}
```
GET /tests/users/{id}
```


#### 说明
根据url的id来获取用户详细信息


#### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int32)|
|**Query**|**pageNum**  <br>*必填*|pageNum|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|pageSize|integer (int32)|
|**Query**|**version**  <br>*可选*|version|number (double)|
|**Body**|**id2**  <br>*可选*|第一个id|string|


#### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«user»](#7fc848851d4397b4476e7ae42fabba96)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


#### 消耗

* `application/json`


#### 生成

* `*/*`


#### 标签

* 测试接口
* 获取用户详细信息2


#### HTTP请求示例

##### 请求 path
```
/tests/users/0
```


##### 请求 query
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0,
  "version" : 0.0
}
```


##### 请求 body
```
json :
{ }
```


#### HTTP响应示例

##### 响应 200
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


<a name="getinfosusingget_1"></a>
### 获取用户列表信息
```
GET /users/list
```


#### 说明
根据url的id来获取用户列表信息


#### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«List«user»»](#ac84df2c73d09727d02dce3e95f66e79)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


#### 消耗

* `application/json`


#### 生成

* `*/*`


#### 标签

* 用戶接口
* 获取用户列表信息2


#### HTTP请求示例

##### 请求 path
```
/users/list
```


#### HTTP响应示例

##### 响应 200
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


<a name="getinfousingget_1"></a>
### 获取用户详细信息
```
GET /users/users/{id}
```


#### 说明
根据url的id来获取用户详细信息


#### 参数

|类型|名称|说明|类型|
|---|---|---|---|
|**Path**|**id**  <br>*必填*|id|integer (int32)|
|**Query**|**pageNum**  <br>*必填*|pageNum|integer (int32)|
|**Query**|**pageSize**  <br>*可选*|pageSize|integer (int32)|
|**Query**|**version**  <br>*可选*|version|number (double)|
|**Body**|**id2**  <br>*可选*|第一个id|string|


#### 响应

|HTTP代码|说明|类型|
|---|---|---|
|**200**|OK|[返回信息«user»](#7fc848851d4397b4476e7ae42fabba96)|
|**401**|Unauthorized|无内容|
|**403**|Forbidden|无内容|
|**404**|Not Found|无内容|


#### 消耗

* `application/json`


#### 生成

* `*/*`


#### 标签

* 用戶接口
* 获取用户详细信息1


#### HTTP请求示例

##### 请求 path
```
/users/users/0
```


##### 请求 query
```
json :
{
  "pageNum" : 0,
  "pageSize" : 0,
  "version" : 0.0
}
```


##### 请求 body
```
json :
{ }
```


#### HTTP响应示例

##### 响应 200
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



