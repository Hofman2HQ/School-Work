package hw2;

public class PlainTextDocument extends Document {
	private Document PlainDoc;
	
	public PlainTextDocument(String FileName, int WordsInLine, String text) {
		super(FileName, WordsInLine, text);
	}
	
	
	
	@Override
	public void AddText(String moreText) {
		moreText = this.getText()+" "+moreText;
		this.setText(moreText);
	}



	@Override
	public void DeleteAll() {
		this.setText("");
		System.out.println("Text has been deleted");
	}



	@Override
	public boolean IsSame(Document d1) {
		int compare = this.getFileName().compareTo(d1.getFileName());
		if (compare == 0)
			return true;
		return false;
	}



	public String ToString()
	{
		String[] textArr = this.getText().split(" ");
		int i = 0;
		int j = 0;
		while (i < textArr.length)
		{
			while (j < 10 && i < textArr.length)
			{
				System.out.print(textArr[i]+" ");
				i++;
				j++;
			}
			System.out.println();
			j = 0;
		}
		return null;
	}
}
