package hw2;

public class WordDocument extends PlainTextDocument {
	
	public WordDocument (String FileName, int WordsInLine, String text)
	{
		super(FileName, WordsInLine, text);
	}

	@Override
	public String ToString() {
		String[] textArr = this.getText().split(" ");
		int i = 0;
		int j = 0;
		while (i < textArr.length)
		{
			System.out.print('*');
			while (j < 8 && i < textArr.length)
			{
				System.out.print(textArr[i]+" ");
				i++;
				j++;
			}
			System.out.print('*');
			System.out.println();
			j = 0;
		}
		return null;
	}
	

}
