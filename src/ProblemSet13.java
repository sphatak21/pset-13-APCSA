public class ProblemSet13 {
    
    public boolean groupSum(int start, int[] numbers, int target) {
        if(start == numbers.length){
            return false;
        }
        if(numbers[start] == target){
            return true;
        }else if(numbers[start] > target){
            return groupSum(start + 1, numbers, target);
        }else{
            boolean result = groupSum(start + 1, numbers, target - numbers[start]);
            if(!result){
                return groupSum(start + 1, numbers, target);
            }
            return result;
        }
    }

    public boolean groupSum6(int start, int[] numbers, int target) {
        int initSixSum = 0;
        for(int i = start; i < numbers.length; i++){
            if(numbers[i] == 6){
                initSixSum+=6;
                numbers[i] = 0;
            }
        }
        if(target - initSixSum <= 0){
            return target % 6 == 0;
        }
        return groupSum(start, numbers, target - initSixSum);
    }

    public boolean groupNoAdj(int start, int[] numbers, int target) {
        if(start >= numbers.length){
            return false;
        }
        if(numbers[start] == target){
            return true;
        }else if(numbers[start] > target){
            return groupNoAdj(start + 1, numbers, target);
        }else{
            boolean result = groupNoAdj(start + 2, numbers, target - numbers[start]);
            if(!result){
                return groupNoAdj(start + 1, numbers, target);
            }
            return result;
        }
    }

    public boolean groupSum5(int start, int[] numbers, int target) {
        if(start == numbers.length){
            return false;
        }
        if(numbers[start] == target){
            return true;
        }else if(numbers[start] > target){
            return groupSum5(start + 1, numbers, target);
        }else{
            if(numbers[start] % 5 == 0){
                boolean result;
                if(numbers[start + 1] == 1){
                    result = groupSum5(start + 2, numbers, target - numbers[start]);
                }else{
                    result = groupSum5(start + 1, numbers, target - numbers[start]);
                }
                return result;
            }else {
                boolean result = groupSum5(start + 1, numbers, target - numbers[start]);
                if(!result){
                    return groupSum5(start + 1, numbers, target);
                }
                return result;
            }
        }
    }

    public boolean groupSumClump(int start, int[] numbers, int target) {
        if(start == numbers.length){
            return false;
        }
        if(numbers[start] == target){
            return true;
        }else if(numbers[start] > target){
            return groupSumClump(start + 1, numbers, target);
        }else{
            boolean result = false;
                if(start < numbers.length - 1 && numbers[start] == numbers[start + 1]){
                    result = groupSumClump(start + 1, numbers, target - numbers[start]);
                    if(!result){
                        result = groupSumClump(start + 2, numbers, target);
                    }
                }else if(start > 0 && numbers[start] == numbers[start - 1]){
                    result = groupSumClump(start + 1, numbers, target - numbers[start]);
                    if(!result){
                        result = groupSumClump(start + 2, numbers, target + numbers[start]);
                    }
                }else{
                    result = groupSumClump(start + 1, numbers, target - numbers[start]);
                    if(!result){
                        return groupSumClump(start + 1, numbers, target);
                    }
                }
            return result;
        }
    }

    public boolean splitArray(int[] numbers) {
        int totalSum = 0;
        for(int i : numbers){
            totalSum += i;
        }
        if(totalSum%2==1){
            return false;
        }else{
            return groupSum(0 , numbers, totalSum/2);
        }
    }


    public boolean splitOdd(int[] numbers) {
        if(numbers.length == 1){
            return numbers[0] % 2 == 1;
        }
        int totalSum = 0;
        for(int i : numbers) {
            totalSum += i;
        }
        int sumTenMultiples = 0;
        for(int i = 10; i <= totalSum; i+=10){
            if(!groupSum(0, numbers, i)){
                sumTenMultiples = i;
                break;
            }
        }
        return (totalSum - sumTenMultiples) % 2 == 1;
    }
}
