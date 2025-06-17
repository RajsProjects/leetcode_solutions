MOD = 10**9 + 7
mx = 10**5 + 10
fact = [1] * mx
invFact = [1] * mx

for i in range(1, mx):
    fact[i] = fact[i - 1] * i % MOD
invFact[-1] = pow(fact[-1], MOD - 2, MOD)
for i in range(mx - 2, -1, -1):
    invFact[i] = invFact[i + 1] * (i + 1) % MOD

def comb(n, r):
    return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD

class Solution:
    def countGoodArrays(self, n: int, m: int, k: int) -> int:
        return comb(n - 1, k) * m % MOD * pow(m - 1, n - k - 1, MOD) % MOD
