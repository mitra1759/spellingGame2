package com.example.rc211.spellinggame;

import java.util.ArrayList;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements
        TextToSpeech.OnInitListener {

    /**
     * Called when the activity is first created.
     */
    private TextToSpeech tts;
    TextView wordText;
    TextView scoreText;
    TextView timeText;
    TextView lifeText;
    TextView nameView;
    EditText wordInput;
    ImageButton enterButton;
    ImageButton speakButton;
    ImageButton hintButton;
    ImageButton skipButton;
    Button restartButton;
    ImageView splashView;
    ImageView logoView;
    CountDownTimer waitTimer;
    int hintIndex = 0;
    int points = 0;
    int time = 60;
    int lives =3;
    ArrayList words = new ArrayList();
    String[] array = new String[]{"ability",
            "able",
            "about",
            "above",
            "accept",
            "according",
            "account",
            "across",
            "act",
            "action",
            "activity",
            "actually",
            "add",
            "address",
            "administration",
            "admit",
            "adult",
            "affect",
            "after",
            "again",
            "against",
            "age",
            "agency",
            "agent",
            "ago",
            "agree",
            "agreement",
            "ahead",
            "air",
            "all",
            "allow",
            "almost",
            "alone",
            "along",
            "already",
            "also",
            "although",
            "always",
            "American",
            "among",
            "amount",
            "analysis",
            "and",
            "animal",
            "another",
            "answer",
            "any",
            "anyone",
            "anything",
            "appear",
            "apply",
            "approach",
            "area",
            "argue",
            "arm",
            "around",
            "arrive",
            "art",
            "article",
            "artist",
            "as",
            "ask",
            "assume",
            "at",
            "attention",
            "attorney",
            "audience",
            "author",
            "authority",
            "available",
            "avoid",
            "away",
            "baby",
            "back",
            "bad",
            "bag",
            "ball",
            "bank",
            "bar",
            "base",
            "be",
            "beat",
            "beautiful",
            "because",
            "become",
            "bed",
            "before",
            "begin",
            "behavior",
            "behind",
            "believe",
            "benefit",
            "best",
            "better",
            "between",
            "beyond",
            "big",
            "bill",
            "billion",
            "bit",
            "black",
            "blood",
            "blue",
            "board",
            "body",
            "book",
            "born",
            "both",
            "box",
            "boy",
            "break",
            "bring",
            "brother",
            "budget",
            "build",
            "building",
            "business",
            "but",
            "buy",
            "by",
            "call",
            "camera",
            "campaign",
            "can",
            "cancer",
            "candidate",
            "capital",
            "car",
            "card",
            "care",
            "career",
            "carry",
            "case",
            "catch",
            "cause",
            "cell",
            "center",
            "central",
            "century",
            "certain",
            "certainly",
            "chair",
            "challenge",
            "chance",
            "change",
            "character",
            "charge",
            "check",
            "child",
            "choice",
            "choose",
            "church",
            "citizen",
            "city",
            "civil",
            "claim",
            "class",
            "clear",
            "clearly",
            "close",
            "coach",
            "cold",
            "collection",
            "college",
            "color",
            "come",
            "commercial",
            "common",
            "community",
            "company",
            "compare",
            "computer",
            "concern",
            "condition",
            "conference",
            "Congress",
            "consider",
            "consumer",
            "contain",
            "continue",
            "control",
            "cost",
            "could",
            "country",
            "couple",
            "course",
            "court",
            "cover",
            "create",
            "crime",
            "cultural",
            "culture",
            "cup",
            "current",
            "customer",
            "cut",
            "dark",
            "data",
            "daughter",
            "day",
            "dead",
            "deal",
            "death",
            "debate",
            "decade",
            "decide",
            "decision",
            "deep",
            "defense",
            "degree",
            "Democrat",
            "democratic",
            "describe",
            "design",
            "despite",
            "detail",
            "determine",
            "develop",
            "development",
            "die",
            "difference",
            "different",
            "difficult",
            "dinner",
            "direction",
            "director",
            "discover",
            "discuss",
            "discussion",
            "disease",
            "do",
            "doctor",
            "dog",
            "door",
            "down",
            "draw",
            "dream",
            "drive",
            "drop",
            "during",
            "each",
            "early",
            "east",
            "easy",
            "eat",
            "economic",
            "economy",
            "edge",
            "education",
            "effect",
            "effort",
            "eight",
            "either",
            "election",
            "else",
            "employee",
            "end",
            "energy",
            "enjoy",
            "enough",
            "enter",
            "entire",
            "environment",
            "environmental",
            "especially",
            "establish",
            "even",
            "evening",
            "event",
            "ever",
            "every",
            "everybody",
            "everyone",
            "everything",
            "evidence",
            "exactly",
            "example",
            "executive",
            "exist",
            "expect",
            "experience",
            "expert",
            "explain",
            "eye",
            "face",
            "fact",
            "factor",
            "fail",
            "fall",
            "family",
            "far",
            "fast",
            "father",
            "fear",
            "federal",
            "feel",
            "feeling",
            "few",
            "field",
            "fight",
            "figure",
            "fill",
            "film",
            "final",
            "finally",
            "financial",
            "find",
            "fine",
            "finger",
            "finish",
            "fire",
            "firm",
            "first",
            "fish",
            "five",
            "floor",
            "fly",
            "focus",
            "follow",
            "food",
            "foot",
            "for",
            "force",
            "foreign",
            "forget",
            "form",
            "former",
            "forward",
            "four",
            "free",
            "friend",
            "from",
            "front",
            "full",
            "fund",
            "future",
            "game",
            "garden",
            "gas",
            "general",
            "generation",
            "get",
            "girl",
            "give",
            "glass",
            "go",
            "goal",
            "good",
            "government",
            "great",
            "green",
            "ground",
            "group",
            "grow",
            "growth",
            "guess",
            "gun",
            "guy",
            "hair",
            "half",
            "hand",
            "hang",
            "happen",
            "happy",
            "hard",
            "have",
            "he",
            "head",
            "health",
            "hear",
            "heart",
            "heat",
            "heavy",
            "help",
            "her",
            "here",
            "herself",
            "high",
            "him",
            "himself",
            "his",
            "history",
            "hit",
            "hold",
            "home",
            "hope",
            "hospital",
            "hot",
            "hotel",
            "hour",
            "house",
            "how",
            "however",
            "huge",
            "human",
            "hundred",
            "husband",
            "idea",
            "identify",
            "if",
            "image",
            "imagine",
            "impact",
            "important",
            "improve",
            "in",
            "include",
            "including",
            "increase",
            "indeed",
            "indicate",
            "individual",
            "industry",
            "information",
            "inside",
            "instead",
            "institution",
            "interest",
            "interesting",
            "international",
            "interview",
            "into",
            "investment",
            "involve",
            "issue",
            "it",
            "item",
            "its",
            "itself",
            "job",
            "join",
            "just",
            "keep",
            "key",
            "kid",
            "kill",
            "kind",
            "kitchen",
            "know",
            "knowledge",
            "land",
            "language",
            "large",
            "last",
            "late",
            "later",
            "laugh",
            "law",
            "lawyer",
            "lay",
            "lead",
            "leader",
            "learn",
            "least",
            "leave",
            "left",
            "leg",
            "legal",
            "less",
            "let",
            "letter",
            "level",
            "lie",
            "life",
            "light",
            "like",
            "likely",
            "line",
            "list",
            "listen",
            "little",
            "live",
            "local",
            "long",
            "look",
            "lose",
            "loss",
            "lot",
            "love",
            "low",
            "machine",
            "magazine",
            "main",
            "maintain",
            "major",
            "majority",
            "make",
            "man",
            "manage",
            "management",
            "manager",
            "many",
            "market",
            "marriage",
            "material",
            "matter",
            "may",
            "maybe",
            "me",
            "mean",
            "measure",
            "media",
            "medical",
            "meet",
            "meeting",
            "member",
            "memory",
            "mention",
            "message",
            "method",
            "middle",
            "might",
            "military",
            "million",
            "mind",
            "minute",
            "miss",
            "mission",
            "model",
            "modern",
            "moment",
            "money",
            "month",
            "more",
            "morning",
            "most",
            "mother",
            "mouth",
            "move",
            "movement",
            "movie",
            "much",
            "music",
            "must",
            "my",
            "myself",
            "name",
            "nation",
            "national",
            "natural",
            "nature",
            "near",
            "nearly",
            "necessary",
            "need",
            "network",
            "never",
            "new",
            "news",
            "newspaper",
            "next",
            "nice",
            "night",
            "no",
            "none",
            "nor",
            "north",
            "not",
            "note",
            "nothing",
            "notice",
            "now",
            "number",
            "occur",
            "of",
            "off",
            "offer",
            "office",
            "officer",
            "official",
            "often",
            "oh",
            "oil",
            "ok",
            "old",
            "on",
            "once",
            "one",
            "only",
            "onto",
            "open",
            "operation",
            "opportunity",
            "option",
            "or",
            "order",
            "organization",
            "other",
            "others",
            "our",
            "out",
            "outside",
            "over",
            "own",
            "owner",
            "page",
            "pain",
            "painting",
            "paper",
            "parent",
            "part",
            "participant",
            "particular",
            "particularly",
            "partner",
            "party",
            "pass",
            "past",
            "patient",
            "pattern",
            "pay",
            "peace",
            "people",
            "per",
            "perform",
            "performance",
            "perhaps",
            "period",
            "person",
            "personal",
            "phone",
            "physical",
            "pick",
            "picture",
            "piece",
            "place",
            "plan",
            "plant",
            "play",
            "player",
            "point",
            "police",
            "policy",
            "political",
            "politics",
            "poor",
            "popular",
            "population",
            "position",
            "positive",
            "possible",
            "power",
            "practice",
            "prepare",
            "present",
            "president",
            "pressure",
            "pretty",
            "prevent",
            "price",
            "private",
            "probably",
            "problem",
            "process",
            "produce",
            "product",
            "production",
            "professional",
            "professor",
            "program",
            "project",
            "property",
            "protect",
            "prove",
            "provide",
            "public",
            "pull",
            "purpose",
            "push",
            "put",
            "quality",
            "question",
            "quickly",
            "quite",
            "race",
            "radio",
            "raise",
            "range",
            "rate",
            "rather",
            "reach",
            "read",
            "ready",
            "real",
            "reality",
            "realize",
            "really",
            "reason",
            "receive",
            "recent",
            "recently",
            "recognize",
            "record",
            "red",
            "reduce",
            "reflect",
            "region",
            "relate",
            "relationship",
            "religious",
            "remain",
            "remember",
            "remove",
            "report",
            "represent",
            "Republican",
            "require",
            "research",
            "resource",
            "respond",
            "response",
            "responsibility",
            "rest",
            "result",
            "return",
            "reveal",
            "rich",
            "right",
            "rise",
            "risk",
            "road",
            "rock",
            "role",
            "room",
            "rule",
            "run",
            "safe",
            "same",
            "save",
            "say",
            "scene",
            "school",
            "science",
            "scientist",
            "score",
            "sea",
            "season",
            "seat",
            "second",
            "section",
            "security",
            "see",
            "seek",
            "seem",
            "sell",
            "send",
            "senior",
            "sense",
            "series",
            "serious",
            "serve",
            "service",
            "set",
            "seven",
            "several",
            "shake",
            "share",
            "she",
            "shoot",
            "short",
            "shot",
            "should",
            "shoulder",
            "show",
            "side",
            "sign",
            "significant",
            "similar",
            "simple",
            "simply",
            "since",
            "sing",
            "single",
            "sister",
            "sit",
            "site",
            "situation",
            "six",
            "size",
            "skill",
            "skin",
            "small",
            "smile",
            "so",
            "social",
            "society",
            "soldier",
            "some",
            "somebody",
            "someone",
            "something",
            "sometimes",
            "son",
            "song",
            "soon",
            "sort",
            "sound",
            "source",
            "south",
            "southern",
            "space",
            "speak",
            "special",
            "specific",
            "speech",
            "spend",
            "sport",
            "spring",
            "staff",
            "stage",
            "stand",
            "standard",
            "star",
            "start",
            "state",
            "statement",
            "station",
            "stay",
            "step",
            "still",
            "stock",
            "stop",
            "store",
            "story",
            "strategy",
            "street",
            "strong",
            "structure",
            "student",
            "study",
            "stuff",
            "style",
            "subject",
            "success",
            "successful",
            "such",
            "suddenly",
            "suffer",
            "suggest",
            "summer",
            "support",
            "sure",
            "surface",
            "system",
            "table",
            "take",
            "talk",
            "task",
            "tax",
            "teach",
            "teacher",
            "team",
            "technology",
            "television",
            "tell",
            "ten",
            "tend",
            "term",
            "test",
            "than",
            "thank",
            "that",
            "the",
            "their",
            "them",
            "themselves",
            "then",
            "theory",
            "there",
            "these",
            "they",
            "thing",
            "think",
            "third",
            "this",
            "those",
            "though",
            "thought",
            "thousand",
            "threat",
            "three",
            "through",
            "throughout",
            "throw",
            "thus",
            "time",
            "to",
            "today",
            "together",
            "tonight",
            "too",
            "top",
            "total",
            "tough",
            "toward",
            "town",
            "trade",
            "traditional",
            "training",
            "travel",
            "treat",
            "treatment",
            "tree",
            "trial",
            "trip",
            "trouble",
            "true",
            "truth",
            "try",
            "turn",
            "TV",
            "two",
            "type",
            "under",
            "understand",
            "unit",
            "until",
            "up",
            "upon",
            "us",
            "use",
            "usually",
            "value",
            "various",
            "very",
            "victim",
            "view",
            "violence",
            "visit",
            "voice",
            "vote",
            "wait",
            "walk",
            "wall",
            "want",
            "war",
            "watch",
            "water",
            "way",
            "we",
            "weapon",
            "wear",
            "week",
            "weight",
            "well",
            "west",
            "western",
            "what",
            "whatever",
            "when",
            "where",
            "whether",
            "which",
            "while",
            "white",
            "who",
            "whole",
            "whom",
            "whose",
            "why",
            "wide",
            "wife",
            "will",
            "win",
            "wind",
            "window",
            "wish",
            "with",
            "within",
            "without",
            "woman",
            "wonder",
            "word",
            "work",
            "worker",
            "world",
            "worry",
            "would",
            "write",
            "writer",
            "wrong",
            "yard",
            "yeah",
            "year",
            "yes",
            "yet",
            "you",
            "young",
            "your",
            "yourself"};
    int index = (int) (Math.random() * array.length);
    String wordBlanks = "";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//https://stackoverflow.com/questions/14122690/edit-text-with-round-corner-and-shadow
        tts = new TextToSpeech(this, this);
        wordInput = findViewById(R.id.wordInput);
        wordText = findViewById(R.id.wordText);
        scoreText = findViewById(R.id.scoreText);
        timeText = findViewById(R.id.timeText);
        lifeText = findViewById(R.id.lifeText);
        enterButton = findViewById(R.id.enterButton);
        speakButton = findViewById(R.id.speakButton);
        skipButton = findViewById(R.id.skipButton);
        hintButton = findViewById(R.id.hintButton);
        restartButton= findViewById(R.id.restartButton);
        splashView = findViewById(R.id.splashView);
        nameView = findViewById(R.id.nameView);
        logoView = findViewById(R.id.logoView);
        // button on click event
//        startTimer();
//        words.add(array[index]);
        for (int i = 0; i < array[index].length(); i++) {
            wordBlanks += "_ ";
        }
        waitTimer = new CountDownTimer(4000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                splashView.setVisibility(View.INVISIBLE);
                logoView.setVisibility(View.INVISIBLE);
                nameView.setVisibility(View.INVISIBLE);
                startTimer();
            }
        }.start();
        wordText.setText(wordBlanks);
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (wordInput.getText().toString().compareToIgnoreCase(array[index])==0) {
                    wordInput.setText("", TextView.BufferType.EDITABLE);
                    points += array[index].length() - hintIndex;
                    index = (int) (Math.random() * array.length);
                    hintIndex = 0;
                    wordBlanks = "";
                    for (int i = 0; i < array[index].length(); i++) {
                        wordBlanks += "_ ";
                    }
                    waitTimer = new CountDownTimer(600, 300) {
                        public void onTick(long millisUntilFinished) {
                            wordInput.setBackgroundResource(R.drawable.correct);
                        }

                        public void onFinish() {
                            wordInput.setBackgroundResource(R.drawable.style);
                        }
                    }.start();
                    wordText.setText(wordBlanks);
                }
                else{
                    skipWord();
                    waitTimer = new CountDownTimer(600, 300) {
                        public void onTick(long millisUntilFinished) {
                            wordInput.setBackgroundResource(R.drawable.incorrect);
                        }

                        public void onFinish() {
                            wordInput.setBackgroundResource(R.drawable.style);
                        }
                    }.start();

                }
                scoreText.setText("Score: "+points + "");
//                Toast.makeText(MainActivity.this,
//                        array[index], Toast.LENGTH_LONG).show();
            }

        });
        hintButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                String temp1 = "";
                if ((hintIndex < array[index].length() - 1)) {
                    hintIndex++;
                }
                for (int i = 0; i < array[index].length() - hintIndex; i++) {
                    temp1 += "_ ";
                }
                wordBlanks = array[index].substring(0, hintIndex) + temp1;
                wordText.setText(wordBlanks);
            }

        });
        restartButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                newGame();
            }

        });
        skipButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                skipWord();

            }

        });

        speakButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                speakOut();
            }

        });
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                enterButton.setEnabled(true);
//                speakOut();
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    private void speakOut() {

//        CharSequence text = wordInput.getText();
        CharSequence text = array[index];
        tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, "id1");

    }

    private void startTimer() {
        waitTimer = new CountDownTimer(60000, 1000) {
            public void onTick(long millisUntilFinished) {
                time--;
                timeText.setText(time + "");
            }

            public void onFinish() {
                endGame();
            }
        }.start();
    }

    private void endGame() {
        if (time <= 1 || lives <= 0) {
            if(time<=1){
                words.add(array[index]);
            }
            String tempList="Words Missed: ";
            if(waitTimer != null) {
                waitTimer.cancel();
                waitTimer = null;
            }
            timeText.setVisibility(View.INVISIBLE);
//            scoreText.setVisibility(View.INVISIBLE);
            enterButton.setVisibility(View.INVISIBLE);
            speakButton.setVisibility(View.INVISIBLE);
            hintButton.setVisibility(View.INVISIBLE);
            skipButton.setVisibility(View.INVISIBLE);
            lifeText.setVisibility(View.INVISIBLE);
//            wordText.setVisibility(View.INVISIBLE);
            wordInput.setVisibility(View.INVISIBLE);
            restartButton.setVisibility(View.VISIBLE);
            for(int i=0; i<words.size();i++) {
                tempList+=words.get(i).toString()+", ";
            }
            wordText.setText(tempList);
            scoreText.setText("You Finished with "+points+" points");

       }
    }
    private void skipWord(){
        words.add(array[index]);
        wordInput.setText("", TextView.BufferType.EDITABLE);
        index = (int) (Math.random() * array.length);
        hintIndex = 0;
        wordBlanks = "";
        for (int i = 0; i < array[index].length(); i++) {
            wordBlanks += "_ ";
        }
        if (points >= 1)
            points--;
        wordText.setText(wordBlanks);
        scoreText.setText("Score: "+points + "");
        lives--;
        lifeText.setText("Lives: "+lives);
        endGame();
    }
    private void newGame(){
        words.clear();
        index = (int) (Math.random() * array.length);
        hintIndex = 0;
        wordBlanks = "";
        for (int i = 0; i < array[index].length(); i++) {
            wordBlanks += "_ ";
        }
        points=0;
        lives=3;
        time=61;
        if(waitTimer != null) {
            waitTimer.cancel();
            waitTimer = null;
        }
        startTimer();
        timeText.setVisibility(View.VISIBLE);
        scoreText.setVisibility(View.VISIBLE);
        enterButton.setVisibility(View.VISIBLE);
        speakButton.setVisibility(View.VISIBLE);
        hintButton.setVisibility(View.VISIBLE);
        skipButton.setVisibility(View.VISIBLE);
        lifeText.setVisibility(View.VISIBLE);
        wordText.setVisibility(View.VISIBLE);
        wordInput.setVisibility(View.VISIBLE);
        restartButton.setVisibility(View.INVISIBLE);
        lifeText.setText("Lives: 3");
        wordText.setText(wordBlanks);
        scoreText.setText("Score: 0");
    }
}

