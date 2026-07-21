# Learning Day / Tech Q&A

Study materials organized by day, then by tech. Each question (and each answer, when you add one) lives in its own file.

## Layout

```text
day-NN/
  java/
    questions/01.md
    answers/01.md      # optional — add when ready
  cicd/
    questions/01.md
    answers/01.md
  leetcode/
    questions/01.md
    answers/01.md
```

- **Day** — `day-01`, `day-02`, …
- **Tech** — include only the folders you need that day (`java`, `cicd`, `leetcode`)
- **Pairing** — when answers exist, `questions/NN.md` matches `answers/NN.md`

## Add a new day

1. Copy `templates/day-NN/` to `day-02/` (or the next day number).
2. Delete tech folders you are not using that day.
3. Fill `questions/NN.md`. Add matching `answers/NN.md` later if you want.

## File format

Question file:

```markdown
# Q01

...single question...
```

Answer file (optional):

```markdown
# A01

...single matching answer...
```
