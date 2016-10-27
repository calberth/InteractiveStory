package cah.interactivestory.model;

public class Page {
   private int mImageId;
   private String mtext;
   private Choice mChoice1;
   private Choice mChoice2;
   private Boolean mIsFinal = false;

   public Page ( int imageId, String text, Choice choice1, Choice choice2) {
      mImageId = imageId;
      mtext = text;
      mChoice1 = choice1;
      mChoice2 = choice2;
   }
   public Page ( int imageId, String text) { //alternate constructor for endings
      mImageId = imageId;
      mtext = text;
      mChoice1 = null;
      mChoice2 = null;
      mIsFinal = true;
   }

   public boolean isFinal() {
      return mIsFinal;
   }

   public int getImageId() {
      return mImageId;
   }

   public String getMtext() {
      return mtext;
   }

   public Choice getChoice1() {
      return mChoice1;
   }

   public Choice getChoice2() {
      return mChoice2;
   }

   public void setImageId(int imageId) {
      mImageId = imageId;
   }

   public void setMtext(String mtext) {
      this.mtext = mtext;
   }

   public void setChoice1(Choice choice1) {
      mChoice1 = choice1;
   }

   public void setChoice2(Choice choice2) {
      mChoice2 = choice2;
   }
}
