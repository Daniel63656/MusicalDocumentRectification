grammar MusicScript;

score: 'bos' event+ 'eos';
event: BARL? STAFF staff ('&' staff)?;
staff: meta* ottavastart? group+ ottavaend?;
group: NEWV? rest VEND? | NEWV? chord VEND? | GRACE chord group;
rest: REST BEAM? DOT*;
chord: WHOLE note+ DOT* | HALF STEM note+ DOT* | STEM note+ DOT* | STEM BEAM? FLAG? note+ DOT*;
note: accidental? TIE_END? LINE TIE_START?;
accidental: SHARP | FLAT |NATURAL | 'x' | '-';
meta: CLEF | time | key;
time: DIGIT+ SLASH DIGIT+;
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
BEAM: '[' | '=' | ']';
STEM: 'up' | 'dn';
LINE: 'l' ('-')? [0-9]+;
SHARP: '#';
FLAT: 'b';
NATURAL: 'n';
CLEF: 'gclef' | 'fclef';
DIGIT: [0-9];
SLASH: '/';
OTTV: '8va' | '8vb';