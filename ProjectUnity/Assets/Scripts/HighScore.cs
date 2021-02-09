using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class HighScore : MonoBehaviour 
{
   int hightscore=0;
    void Start () {

        
        hightscore = PlayerPrefs.GetInt("Hightscoree");
        (Tens.gameObject as GameObject).SetActive(false);
        (Hundreds.gameObject as GameObject).SetActive(false);
         if (hightscore>ScoreManagerScript.Score) //save perf from non needed calculations
        { 
            if(hightscore< 10)
            {
                //just draw units
                Units.sprite = numberSprites[hightscore];
            }
            else if(hightscore >= 10 && hightscore < 100)
            {
                (Tens.gameObject as GameObject).SetActive(true);
                Tens.sprite = numberSprites[hightscore / 10];
                Units.sprite = numberSprites[hightscore % 10];
            }
            else if(hightscore >= 100)
            {
                (Hundreds.gameObject as GameObject).SetActive(true);
                Hundreds.sprite = numberSprites[hightscore / 100];
                int rest = hightscore % 100;
                Tens.sprite = numberSprites[rest / 10];
                Units.sprite = numberSprites[rest % 10];
            }
        }

        else
        {
                if(ScoreManagerScript.Score< 10)
            {
                //just draw units
                
                Units.sprite = numberSprites[ScoreManagerScript.Score];
                PlayerPrefs.SetInt("Hightscoree",ScoreManagerScript.Score);
            }
            else if(ScoreManagerScript.Score >= 10 && ScoreManagerScript.Score < 100)
            {
                (Tens.gameObject as GameObject).SetActive(true);
                Tens.sprite = numberSprites[ScoreManagerScript.Score / 10];
                Units.sprite = numberSprites[ScoreManagerScript.Score% 10];
                PlayerPrefs.SetInt("Hightscoree",ScoreManagerScript.Score);
            }
            else if(ScoreManagerScript.Score >= 100)
            {
                (Hundreds.gameObject as GameObject).SetActive(true);
                Hundreds.sprite = numberSprites[ScoreManagerScript.Score / 100];
                int rest = ScoreManagerScript.Score % 100;
                Tens.sprite = numberSprites[rest / 10];
                Units.sprite = numberSprites[rest % 10];
                PlayerPrefs.SetInt("Hightscoree",ScoreManagerScript.Score);
            }

        }
	}
	
	// Update is called once per frame
	void Update () {

       

	}


    int previousScore = -1;
    public Sprite[] numberSprites;
    public SpriteRenderer Units, Tens, Hundreds;
}
