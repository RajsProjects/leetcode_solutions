class Solution:
    def answerString(self, word: str, numFriends: int) -> str:
        n = len(word)
        length = n - numFriends + 1
        if n == 0 or numFriends == 1 or n ==1:
            return word
        chars = []
        for i in range(n):
            chars.append(word[i])
        chars.sort()
        result = ''.join(chars) 
        chars.clear
        lexico = []
        while n:
            sub_string = result[i:length+i]
            if len(sub_string)==length:
                lexico.append(sub_string)
        return lexico[0]
if __name__ == "__main__":
    s = Solution()
    s.answerString("aabagfsde", 4)        