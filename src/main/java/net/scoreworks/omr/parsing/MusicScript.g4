grammar MusicScript;

score: BARL event+;
event: 'T' staff ('&' staff)? BARL? | 'L' staff BARL?;
staff: meta+ ottavastart? group* ottavaend? | ottavastart? group+ ottavaend?;
group: (NEWV | SKPV+)? TUPL? rest | (NEWV | SKPV+)? TUPL? chord | (NEWV | SKPV+)? (GRACE chord)* TUPL? chord;
rest: REST BEAM? DOT*;
chord: note_open+ DOT* | STEM note_open+ DOT* | STEM note_solid+ DOT* | STEM BEAM? FLAG note_solid+ DOT*;
note_open: accidental? TIE_END? NOTE_OPEN TIE_START?;
note_solid: accidental? TIE_END? NOTE_SOLID TIE_START?;
accidental: SHARP | FLAT | NATURAL | 'x' | '-';
meta: CLEF | key | time;
time: DIGIT+ SLASH DIGIT+ | 'c' | '/c';
key: SHARP+ | FLAT+ | NATURAL+;
ottavastart: OTTV;
ottavaend: OTTV;

// TERMINALS
BARL: ':'? '|' ':'?;
NEWV: '+';
SKPV: ';';
GRACE: 'g';
REST: 'r'[0-7];
DOT: '.';
TIE_START: '(';
TIE_END: ')';
FLAG: 'f'[1-5];
BEAM: '[' | ']';
TUPL: '{' | '*' | '}';
STEM: 'u' | 'd';
NOTE_OPEN: 'o' '-'? [0-9]+;
NOTE_SOLID: 's' '-'? [0-9]+;
SHARP: '#';
FLAT: 'b';
NATURAL: 'n';
CLEF: 'G' | 'F';
DIGIT: [0-9];
SLASH: '/';
OTTV: 'va' | 'vb' | 'ma' | 'mb';