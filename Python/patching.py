
from typing import List


class Solution:
    def min_Patches(self, nums: List[int], n: int) -> int:
        result: int = 0
        #max value that could be cover on the list
        max_covered: int = 0 #long int var

        #convert list in
        while(max_covered < n):
            can_cover: bool = False
            sum: int = 0 #long int var

            #check if it can cover the next number using the numbers in nums
            for num in nums:
                #if num is bigger than the next number it needs to cover, break loop
                if num > (max_covered + 1):
                    break
                
                sum += num

                if sum >= (max_covered + 1):
                    can_cover = True
                    break
            
            #if we cant cover next number, insert patch
            if not can_cover:
                patch: int = max_covered + 1
                #position where the patch is going to be inserted
                insert_position: int = self.__find_insert_position(nums, patch)

                #insert patch in list
                nums = self.__insert_at_position(nums, patch, insert_position)

                #debug
                print(f"Inserted patch: {patch} -> {nums}")

                #update max covered value
                max_covered += patch
                result += 1
            else:
                #if we can cover the next number, update max covered value
                max_covered += nums[0]
        
        return result
    
    '''
        Find position that will be required to insert patch
        :params nums: list where the patch is going to be inserted
        :params elements: int value that is going to be inserted
        :return: int position
    '''
    def __find_insert_position(self, nums: List[int], element: int) -> int:
        pos: int = 0

        while(pos < nums.length and nums[pos] < element):
            pos += 1
        
        return pos
    
    
    def __insert_at_position(self, nums: List[int], element: int, position: int) -> List[int]:
        new_nums: List[int] = []

        for i in range(0,position):
            new_nums[i] = nums[i]
        
        new_nums[position] = element

        for i in (position, len(nums)):
            new_nums[i + 1] = nums[i]

        return new_nums