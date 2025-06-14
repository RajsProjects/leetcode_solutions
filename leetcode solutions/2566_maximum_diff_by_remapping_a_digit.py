class Solution:
    def minMaxDifference(self, num: int) -> int:
        temp = str(num)
        for i in range(len(temp)):
            if temp[i] != "9":
                temp = temp.replace(temp[i], "9")
                break
        max_num = int(temp)
        num = str(num)
        for i in range(len(num)):
            if num[i] != "0":
                num = num.replace(num[i], "0")
                break
        min_num = int(num)
        return max_num - min_num
if __name__ == "__main__":
    s = Solution()
    print(s.minMaxDifference(11891))
   
    
        
        