- curl https://uaa.run.pivotal.io/token_key
```
{
    "kty": "RSA",
    "e": "AQAB",
    "use": "sig",
    "kid": "sha2-2017-01-20-key",
    "alg": "RS256",
    "value": "-----BEGIN PUBLIC KEY-----\nMIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAyH6kYCP29faDAUPKtei3\nV/Zh8eCHyHRDHrD0iosvgHuaakK1AFHjD19ojuPiTQm8r8nEeQtHb6mDi1LvZ03e\nEWxpvWwFfFVtCyBqWr5wn6IkY+ZFXfERLn2NCn6sMVxcFV12sUtuqD+jrW8MnTG7\nhofQqxmVVKKsZiXCvUSzfiKxDgoiRuD3MJSoZ0nQTHVmYxlFHuhTEETuTqSPmOXd\n/xJBVRi5WYCjt1aKRRZEz04zVEBVhVkr2H84qcVJHcfXFu4JM6dg0nmTjgd5cZUN\ncwA1KhK2/Qru9N0xlk9FGD2cvrVCCPWFPvZ1W7U7PBWOSBBH6GergA+dk2vQr7Ho\nlQIDAQAB\n-----END PUBLIC KEY-----",
    "n": "AMh-pGAj9vX2gwFDyrXot1f2YfHgh8h0Qx6w9IqLL4B7mmpCtQBR4w9faI7j4k0JvK_JxHkLR2-pg4tS72dN3hFsab1sBXxVbQsgalq-cJ-iJGPmRV3xES59jQp-rDFcXBVddrFLbqg_o61vDJ0xu4aH0KsZlVSirGYlwr1Es34isQ4KIkbg9zCUqGdJ0Ex1ZmMZRR7oUxBE7k6kj5jl3f8SQVUYuVmAo7dWikUWRM9OM1RAVYVZK9h_OKnFSR3H1xbuCTOnYNJ5k44HeXGVDXMANSoStv0K7vTdMZZPRRg9nL61Qgj1hT72dVu1OzwVjkgQR-hnq4APnZNr0K-x6JU"
}
```

- http://localhost:5000/oauth/token
```
{
    "access_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpcnZpbmciLCJzY29wZSI6WyJhbGwiLCJyZWFkIiwid3JpdGUiXSwiZXhwIjoxNTQ0MTgyODMyLCJhdXRob3JpdGllcyI6WyIwMjEwOTgiLCIwMjEwNDAiLCJST0xFX0FETUlOIl0sImp0aSI6IjBkNTE0NGUyLTI5OGMtNDNlNy1iYjc4LWRhYTM0MGU5MWNmNyIsImNsaWVudF9pZCI6ImNsaWVudF90ZXN0IiwidXNlcm5hbWUiOiJpcnZpbmcifQ.aM_7Rc3MddkhsE3YiFGDSLYGPyMb7jVIGkhiluPurieS2qhSJDzPp7Nr53uToNmbOPIHmF8e7_6FN7_JxOqGD3BpeGJjrak5_BQuKdz5sDHgr1SIi16R2jH3uWBZ4YbAcEfBsQczJ73Ret3nGvfzQtGUpQKY6BO-J2ooJQtO76HSoX1wxLOeIE5TjAdlQ2mD_r0YUdaQG17VsxNt3ohMecrtI8AFQah6Tu8WVPW4S4CXujdwYhawlfrhglW_c1mgLxlz44cuuBtOt_drim7VBaymyi_mMBUxHhEvb4k7uLwH6bJItt_f0pzbUGajVqGSy7BdYzYqj_pKgXN2vatdFw",
    "token_type": "bearer",
    "refresh_token": "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJpcnZpbmciLCJzY29wZSI6WyJhbGwiLCJyZWFkIiwid3JpdGUiXSwiYXRpIjoiMGQ1MTQ0ZTItMjk4Yy00M2U3LWJiNzgtZGFhMzQwZTkxY2Y3IiwiZXhwIjoxNTQ0MTg1NjMyLCJhdXRob3JpdGllcyI6WyIwMjEwOTgiLCIwMjEwNDAiLCJST0xFX0FETUlOIl0sImp0aSI6Ijg0MmVmODhjLTU5YzMtNGUxMi1hMjc2LWY1MTRiM2FiYTMyNCIsImNsaWVudF9pZCI6ImNsaWVudF90ZXN0IiwidXNlcm5hbWUiOiJpcnZpbmcifQ.A4BUF-8CgvcxQoHEManyBeNyUmM9Lk5DbytpoL5KthqREwvcF9IpjM9MFz4yCSY5MzFpr9ZVd6JHgGejk0Q9qJMBqNOVhLxaC80VZgHDUP1hvBMc9axR8d_3T55fqLCMq57DyEKeNhcSr6n_r0f4eNKepIW7FrY_V3eZ6wepB5OlrjbY8mS1WZDh001gFZoqDitvr-ISKL8VA_COQXtMDixDrnUu6nqRtN4EQt8ldhwRIIljRBw_SBu1zRBoV70F9gUpF-EyVsXP95dFghgSnbTKGhSlscIe3oFS5wZdjYhmXckQY8Xj4a1RpaEsxPuzJA2nWlhqnVsIsMdXXQw9Kw",
    "expires_in": 3845,
    "scope": "all read write",
    "username": "irving",
    "jti": "0d5144e2-298c-43e7-bb78-daa340e91cf7"
}

```

> Test
- http://localhost:5000/oauth/authorize?response_type=code&client_id=client_test&redirect_uri=http://baidu.com&state=test
- http://localhost:5000/oauth/authorize?client_id=client_test&redirect_uri=http://localhost:9000/callback&response_type=token&scope=read_profile&state=xyz


> Spring Security 入门系列
- http://www.spring4all.com/article/428
- https://my.oschina.net/u/873386/blog/398018
- https://my.oschina.net/taoyuanping/blog/809157
- https://www.jianshu.com/p/5e3f732b81f4
- https://qiita.com/kazuki43zoo/items/658eabbf0d6a60d3ed89
- http://www.spring4all.com/article/577
- http://www.spring4all.com/article/1789