/* 1.  Make a StringUtils class which contains following methods
NOTE: You can use only String.charAt(), methods to code this problem.(Don't use any other inbuilt functions)

static int countChar(String str,char ch)
- Returns occurrence of the given character in the given String (str).
static String substring(String str,int start,int end)
- Returns a substring from the start index to end index with all validation checks.
static String[] split(String str,char ch)
- Returns an array of strings broken according to the occurrence of the given character with validation checks.
static Boolean hasPattern(String str,String pattern)
- Returns true if the give string (pattern) found in the main string (str) otherwise false.
static Boolean allWordsContainsChar(String str,char ch)
- Returns true if all words of the given string (str) contains the given character (ch)  otherwise false.
static String reverse(String str)
- Returns the reverse of the String (Without using extra String or array)
static String reverseVowels(String str)
*/

import java.util.Arrays;
import java.util.Scanner;


public class Main1 {
    static int countChar(String str, char ch) {
        int counter = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ch)
                ++counter;
        }
        return counter;
    }

    static String substring(String str, int start, int end) {
        String finalString = "";
        for (int i = start; i <= end; ++i) {
            finalString = finalString + str.charAt(i);
        }
        return finalString;
    }

    static String[] split(String str, char ch) {
        String splitArray[] = new String[20];
        String messageArray[] = { "Your character is not found" };
        char tempArray[] = new char[20];
        int recentIndex = 0, tempIndex, splitArrayIndex = 0;
        int counter = 0;
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) == ch) {
                tempIndex = 0;
                for (int j = recentIndex; j < i; ++j) {
                    tempArray[tempIndex] = str.charAt(j);
                    ++tempIndex;
                }
                splitArray[splitArrayIndex] = Arrays.toString(tempArray);
                ++splitArrayIndex;
                recentIndex = i + 1;
                ++counter;
            }
        }
        if (counter == 0)
            return messageArray;
        return splitArray;
    }

    static Boolean hasPattern(String str, String pattern) {
        int tempIndex;
        String patternString = "";
        for (int i = 0; i < str.length(); ++i) {
            tempIndex = i;
            for (int j = 0; j < pattern.length(); ++j) {
                if (str.charAt(tempIndex) == pattern.charAt(j))
                    patternString = patternString + str.charAt(tempIndex);
            }
            if (patternString == pattern)
                return true;
        }
        return false;
    }

    static Boolean allWordsContainsChar(String str, char ch) {
        int blankSpaceCount = 0, matchCount = 0;
        int startIndex = 0, endIndex = 0;
        int length = str.length();
        for (int i = 0; i < length; ++i) {
            if (str.charAt(i) == ' ' || i == length - 1) {
                ++blankSpaceCount;
                endIndex = i;
                for (int j = startIndex; j <= endIndex; ++j) {
                    if (str.charAt(j) == ch) {
                        ++matchCount;
                        break;
                    }
                }
                startIndex = i + 1;
            }
        }
        if (matchCount == blankSpaceCount)
            return true;
        return false;
    }

    static StringBuilder reverse(StringBuilder str) {
        int length = str.length();
        for (int i = 0; i < length / 2; ++i) {
            char temp = str.charAt(i);
            str.setCharAt(i, str.charAt(length - 1 - i));
            str.setCharAt(length - 1 - i, temp);
        }
        return str;
    }

    static String reverseVowels(String str) {
        int length = str.length();
        String vowels = "";
        String reversedVowels = "";
        int vowelIndex = 0;
        char tempArray[] = str.toCharArray();
        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == 'a' ||
                    str.charAt(i) == 'e' ||
                    str.charAt(i) == 'i' ||
                    str.charAt(i) == 'o' ||
                    str.charAt(i) == 'u' ||
                    str.charAt(i) == 'A' ||
                    str.charAt(i) == 'E' ||
                    str.charAt(i) == 'I' ||
                    str.charAt(i) == 'O' ||
                    str.charAt(i) == 'U') {
                vowels = vowels + str.charAt(i);
            }
        }
        for (int i = vowels.length() - 1; i  >= 0; --i) {
            reversedVowels = reversedVowels + vowels.charAt(i);
        }
        for (int i = 0; i < length; ++i) {
            if (tempArray[i] == 'a' ||
                    tempArray[i] == 'e' ||
                    tempArray[i] == 'i' ||
                    tempArray[i] == 'o' ||
                    tempArray[i] == 'u' ||
                    tempArray[i] == 'A' ||
                    tempArray[i] == 'E' ||
                    tempArray[i] == 'I' ||
                    tempArray[i] == 'O' ||
                    tempArray[i] == 'U') {
                tempArray[i] = reversedVowels.charAt(vowelIndex);
                ++vowelIndex;
            }
        }
        String finalString = "";
        for (int i = 0; i < length; ++i) {
            finalString = finalString + tempArray[i];
        }
        return finalString;
    }

    public static void main(String[] args) {
        String inputString, patternString;
        char occurrenceCharacter, splitCharacter, wordCharacter;
        int startIndex, endIndex;
        String splitArray[] = new String[20];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your string");
        inputString = scanner.nextLine().trim();
        StringBuilder sBuilder = new StringBuilder();
        sBuilder.append(inputString);
        // System.out.println("Enter your occurence character");
        // occurrenceCharacter = scanner.nextLine().charAt(0);
        // System.out.println(countChar(inputString, occurrenceCharacter));
        // System.out.println("Enter your start index");
        // startIndex = scanner.nextInt();
        // System.out.println("Enter your end index");
        // endIndex = scanner.nextInt();
        // if (startIndex < 0 ||
        // startIndex > inputString.length() - 1 ||
        // endIndex < startIndex ||
        // endIndex > inputString.length() - 1) {
        // System.out.println("Wrong input");
        // System.exit(1);
        // }
        // System.out.println("Your substring is: " + substring(inputString, startIndex,
        // endIndex));
        // System.out.println("Enter your split character");
        // splitCharacter = scanner.next().charAt(0);
        // splitArray = split(inputString, splitCharacter);
        // for (int i = 0; i < splitArray.length; ++i) {
        // try {
        // if (!splitArray[i].isEmpty() || splitArray[i] != null)
        // System.out.print(splitArray[i]);
        // } catch (Exception e) {
        // }
        // }
        // System.out.print("\n");
        System.out.println("Enter you pattern");
        patternString = scanner.next().trim();
        System.out.println(hasPattern(inputString, patternString));
        // System.out.println("Enter your word character");
        // wordCharacter = scanner.next().charAt(0);
        // scanner.close();
        // System.out.println(allWordsContainsChar(inputString, wordCharacter));
        // System.out.println("Reversed string is: " + reverse(sBuilder));
        // System.out.println("Vowel reversed string: " + reverseVowels(inputString));
    }
}