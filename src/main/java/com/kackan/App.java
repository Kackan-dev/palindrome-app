package com.kackan;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        List<String> testList = List.of("abjchba","mmop","kjjjhjjj","abcba","kajakx","aba","racecar","levelx","xftpfx","racecary","shixihso","abcd");
        testList.forEach(el -> System.out.println(stringChallenge(el)));
    }

    public static boolean isItPalindrome(String palindrome) {
        if (palindrome.length() <= 2) {
            return false;
        }

        char[] charArray = palindrome.toCharArray();
        boolean result = true;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] != charArray[charArray.length -1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static String stringChallenge(String palindrome) {
        if (palindrome.length() <= 2) {
            return "not possible";
        }

        if (isItPalindrome(palindrome)) {
            return palindrome;
        }

        for (int i = 0; i < palindrome.length(); i++) {
            String testPalindrome = palindrome.substring(0, i)
                    + palindrome.substring(i+1);
            if (isItPalindrome(testPalindrome)) {
                return ""+palindrome.charAt(i);
            }
        }

        for (int i = 0; i < palindrome.length(); i++) {
            String testPalindrome = palindrome.substring(0, i)
                    + palindrome.substring(i+1);
            for (int j = 0; j < testPalindrome.length(); j++) {
                String testPalindromeWithout2Characters =
                        testPalindrome.substring(0,j)
                        + testPalindrome.substring(j+1);
                if (isItPalindrome(testPalindromeWithout2Characters)) {
                    return ""+palindrome.charAt(i) + testPalindrome.charAt(j);
                }
            }
        }
        return "not possible";
    }
}
