import random
class Solution(object):
    def findSecretWord(self, words, master):
        random.randint(0, 10)
        def get_match_count(word1, word2):
            return sum(c1 == c2 for c1, c2 in zip(word1, word2))
        def get_best_word(words, prev_guesses):
            best_word = None
            best_score = -1
            for word in words:
                if word in prev_guesses:
                    continue
                score = sum(get_match_count(word, other) for other in words if other != word)
                if score > best_score:
                    best_score = score
                    best_word = word
            return best_word
        prev_guesses = set()
        for _ in range(10):
            guess = get_best_word(words, prev_guesses)
            if not guess:
                break
            match_count = master.guess(guess)
            if match_count == 6:
                return
            prev_guesses.add(guess)
            words = [word for word in words if get_match_count(word, guess) == match_count]
        return
if __name__ == "__main__":
    sol = Solution()
    words = ["acckzz", "ccbazz", "eiowzz", "abcczz", "abcczz", "abcczz"]
    class Master:
        def guess(self, word):
            return 6 if word == "abcczz" else 0
    master = Master()
    sol.findSecretWord(words, master)
    print("Secret word found or process completed.")