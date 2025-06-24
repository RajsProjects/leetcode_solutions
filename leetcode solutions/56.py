class Solution:
    def merge(self, intervals: list[list[int]]) -> list[list[int]]:
        output = []
        first = 0
        second = 1
        for i in range(len(intervals) - 1):
            if max(intervals[first]) <= min(intervals[second]) and second<=len(intervals):
                output.append([min(intervals[first]), max(intervals[second])])
                first += 2 
                second += 2
                continue
            else:
                output.append(intervals[first]) 
                first += 1
                second += 1
            first += 1
            second += 1
        return output
if __name__ == "__main__":
    s = Solution()
    intervals = [[1,3],[2,6],[8,10],[15,18]]
    s.merge(intervals)        
       
