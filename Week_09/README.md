第九周学习总结
##常见递推公式
#爬楼梯 f(n) = f(n-1) + f(n-2),f(1)=1,f(0)=0

#不同路径 f(x,y) = f(x-1,y)+f(x,y-1)

#打家劫舍
- dp[i]状态的定义：max $ of robbing A[0 -> i]
- dp[i] = max(dp[i-2] + nums[i],dp[i-1]) 
- dp[i][0]状态定义：max $ of robbing A[0 -> i]且没偷 nums[i]
- dp[i][1]状态定义：max $ of robbing A[0 -> i]且偷 nums[i]

- dp[i][0] = max(dp[i-1][0],dp[i-1][1]);
- dp[i][1] = max(dp[i-1][0] + nums[i];

#最小路径和
- dp[i][j]状态的定义：minPath(A[1 -> i][1 -> j])
- dp[i][j] = min(dp[i-1][j],dp[i][j-1])+A[i][j]

#股票买卖
- dp[i][k][0 or 1] (0 <= i <= n-1, 1 <= k <= K)
• i 为天数
• k 为最多交易次数
• [0,1] 为是否持有股票
总状态数： n * K * 2 种状态
for 0 <= i < n:
for 1 <= k <= K:
for s in {0, 1}:
dp[i][k][s] = max(buy, sell, rest)

- dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
max( 选择 rest , 选择 sell )
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
max( 选择 rest , 选择 buy )
解释：今天我没有持有股票，有两种可能：
- 我昨天就没有持有，然后今天选择 rest，所以我今天还是没有持有；
- 我昨天持有股票，但是今天我 sell 了，所以我今天没有持有股票了。
解释：今天我持有着股票，有两种可能：
- 我昨天就持有着股票，然后今天选择 rest，所以我今天还持有着股票；
- 我昨天本没有持有，但今天我选择 buy，所以今天我就持有股票了。

- 初始状态：dp[-1][k][0] = dp[i][0][0] = 0
dp[-1][k][1] = dp[i][0][1] = -infinity

- 状态转移方程 dp[i][k][0] = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
dp[i][k][1] = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
#编辑距离
- 如果 word1[i] 与 word2[j] 相同，显然 dp[i][j]=dp[i-1][j-1]
- 如果 word1[i] 与 word2[j] 不同，那么 dp[i][j] 可以通过
1. 在 dp[i-1][j-1] 的基础上做 replace 操作达到目的
2. 在 dp[i-1][j] 的基础上做 insert 操作达到目的
3. 在 dp[i][j-1] 的基础上做 delete 操作达到目的
取三者最小情况即可


