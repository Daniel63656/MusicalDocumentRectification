grammar MusicScript;

score: 'bos' event+ 'eos';
event: BARL? STAFF staff ('&' staff)?;
staff: CLEF? key? time? ottavastart? group+ ottavaend?;
group: NEWV? TUPL? rest VEND? | NEWV? TUPL? chord VEND? | GRACE chord group;
rest: REST BEAM? DOT*;
chord: WHOLE note+ DOT* | HALF STEM note+ DOT* | STEM note+ DOT* | STEM FLAG? BEAM? note+ DOT*;
note: accidental? TIE_END? LINE TIE_START?;
accidental: SHARP | FLAT |NATURAL | 'x' | '-';
time: DIGIT+ SLASH DIGIT+ | 'c' | '/c';
key: SHARP+ | FLAT+ | NATURAL+;
ottavastart: OTTV;
ottavaend: OTTV;

// TERMINALS
STAFF: 'T' | 'L';
BARL: '|';
NEWV: '<';
VEND: '>';
GRACE: 'g';
REST: 'r'[0-7];
WHOLE: 'w';
HALF: 'h';
DOT: '.';
TIE_START: '(';
TIE_END: ')';
FLAG: 'f'[1-5];
BEAM: '[' | '+' | ']';
TUPL: '{' | '*' | '}';
STEM: 'u' | 'd';
LINE: 'l' ('-')? [0-9]+;
SHARP: '#';
FLAT: 'b';
NATURAL: 'n';
CLEF: 'G' | 'F';
DIGIT: [0-9];
SLASH: '/';
OTTV: 'va' | 'vb' | 'ma' | 'mb';