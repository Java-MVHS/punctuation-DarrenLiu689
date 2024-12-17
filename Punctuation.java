/* Name: Darren Liu
 * Date: 12/11/2024
 * Period: 6
 * Program: Punctuation.java
 * Description: reads Winston Churchill's speach "Blood, Sweat, and 
 * Tears" and deletes any words not next to any punctuation.
 * 
 * PSEUDOCODE:
 * main 
 * 		D&I speech
 * 		D&I punctuation
 * 		D&I newString
 * 		call searchIt()
 * 
 * searchIt()
 * 		loops through speech for spaces to find words
 * 		sends word into check and adds returned value to newString
 * 		checks last word
 * 		prints everything
 * 
 * check()
 * 		loops through word to find punctuation
 * 		if puncuated return word
 * 		if not puncuated return "" (nothing)
 * 
 * print()
 * 		prints given String
 */


public class Punctuation
{
	//main
	//creates instance of Punctuation and uses it to run searchIt().
	public static void main(String[] args)
	{
		//D&I punctuation
		Punctuation punctuation = new Punctuation();
		//D&I speech
		String speech = new String(
			"Blood, Sweat, and Tears by Winston Churchill " +
			"May 13, 1940" +
			"Mr. Speaker:" +
			"On Friday evening last I received His Majesty’s commission to form a new " +
			"Administration. It was the evident wish and will of Parliament and the nation that this should be conceived on the broadest possible basis and that it should include all parties, both those who supported the late Government and also the parties of the Opposition." +
			"I have completed the most important part of this task. A War Cabinet has been formed of five Members, representing, with the Liberal Opposition, the unity of the nation. The three party Leaders have agreed to serve, either in the War Cabinet or in high executive office. The three Fighting Services have been filled. It was necessary that this should be done in one single day, on account of the extreme urgency and rigour of events. A number of other key positions were filled yesterday, and I am submitting a further list to His Majesty tonight. I hope to complete the appointment of the principal Ministers during tomorrow. The appointment of the other Ministers usually takes a little longer, but I trust that, when Parliament meets again, this part of my task will be completed, and that the Administration will be complete in all respects." +
			"Sir, I considered it in the public interest to suggest that the House should be summoned to meet today. Mr. Speaker agreed and took the necessary steps, in accordance with the powers conferred upon him by the Resolution of the House. At the end of the proceedings today, the Adjournment of the House will be proposed until Tuesday, the 21st May, with, of course, provision for earlier meeting, if need be. The business to be considered during that week will be notified to Members at the earliest opportunity. I now invite the House, by the Resolution which stands in my name, to record its approval of the steps taken and to declare its confidence in the new Government." +
			"Sir, to form an Administration of this scale and complexity is a serious undertaking in itself, but it must be remembered that we are in the preliminary stage of one of the greatest battles in history, that we are in action at many points in Norway and in Holland, that we have to be prepared in the Mediterranean, that the air battle is continuous and that many preparations have to be made here at home. In this crisis I hope I may be pardoned if I do not address the House at any length today. I hope that any of my friends and colleagues, or former colleagues, who are affected by the political reconstruction, will make all allowances for any lack of ceremony with which it has been necessary to act. I would say to the House, as I said to those who’ve joined this government: \"I have nothing to offer but blood, toil, tears and sweat.\"" +
			"We have before us an ordeal of the most grievous kind. We have before us many, many long months of struggle and of suffering. You ask, what is our policy? I will say: It is to wage war, by sea, land and air, with all our might and with all the strength that God can give us; to wage war against a monstrous tyranny, never surpassed in the dark and lamentable catalogue of human crime. That is our policy. You ask, what is our aim? I can answer in one word: victory. Victory at all costs, victory in spite of all terror, victory, however long and hard the road may be; for without victory, there is no survival. Let that be realised; no survival for the British Empire, no survival for all that the British Empire has stood for, no survival for the urge and impulse of the ages, that mankind will move forward towards its goal. " +
			"But I take up my task with buoyancy and hope. I feel sure that our cause will not be suffered to fail among men. At this time I feel entitled to claim the aid of all, and I say, \"Come then, let us go forward together with our united strength.\""
		);
		//D&I newString as blank.
		String newString = new String();
		
		//calls search it using punctuation
		punctuation.searchIt(speech, newString);
	}
	
	//searchIt()
	//searches the speach for each word using spaces and sends it to check
	public void searchIt(String speech, String newString)
	{
		//D&I prevChar
		int prevChar = -1;
		//for loop (loops through speech)
		for (int i = 0; i < speech.length(); i++)
		{
			//checks if space or new line
			if (speech.charAt(i) == ' ' || speech.charAt(i) == '\n')
			{
				//newString adds word if punctuation attached using check()
				newString += check(speech.substring(prevChar+1,i));
				//prevChar changed to this char (a space)
				prevChar = i;
			}
		}
		//at end includes last word
		newString += check(speech.substring(prevChar+1,speech.length()-1));
		
		//prints all words out.
		print(newString);
	}
	
	//check()
	//checks the word for punctuation
	public String check(String word)
	{
		String newWord = word.toLowerCase().trim();
		for (int i = 0; i < newWord.length(); i++)
		{
			if (!(newWord.charAt(i) >= 'a') || !(newWord.charAt(i) <= 'z'))
			{
				return word + " ";
			}
		}
		return "";
	}
	
	//print()
	//prints given String
	public void print(String string)
	{
		//sout
		System.out.println(string);
	}
}
