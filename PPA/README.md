| Rule No | Description                                  | Vulnerability         |
|---------|----------------------------------------------|-----------------------|
| 1       | AES default encryption mode ECB              | Side channel attack   |
| 2       | Insecure cryptographic hash                  | Collision attack      |
| 3       | Presence of AllHostNameVerifier              |   SSL/TLS MitM attack |
| 4       | Abuse of X509TrustManager Verifier Interface |                       |
| 5       | Absence of performing hostname verification  |                       |
| 6       | Weak key length                              | Brute force attack    |
| 7       | Static/constant/predictable keys/IV          |                       |
| 8       | Turning of CSRF protection                   | CSRF attack           |
|         |                                              |                       |