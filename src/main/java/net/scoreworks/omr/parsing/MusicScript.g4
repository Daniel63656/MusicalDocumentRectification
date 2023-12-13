grammar MusicScript;

bar: 'bos' event+ 'eos';
event: 'T' staff ('&' staff)? | 'L' staff;
staff: meta+ ottavastart? group* ottavaend? | ottavastart? group+ ottavaend?;
group: NEWV? TUPL* rest VEND? | NEWV? TUPL* chord VEND? | GRACE chord group;
rest: REST BEAM? DOT*;
chord: note_open+ DOT* | STEM note_open+ DOT* | STEM note_solid+ DOT* | STEM FLAG? BEAM? note_solid+ DOT*;
note_open: accidental? TIE_END? 'o' LINE TIE_START?;
note_solid: accidental? TIE_END? 's' LINE TIE_START?;
accidental: SHARP | FLAT | NATURAL | 'x' | '-';
meta: CLEF | key | time;
time: DIGIT+ SLASH DIGIT+ | 'c' | '/c';
key: SHARP+ | FLAT+ | NATURAL+;
ottavastart: OTTV;
ottavaend: OTTV;

// TERMINALS
NEWV: '<';
VEND: '>';
GRACE: 'g';
REST: 'r'[0-7];
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